package com.z5.zcms.admsys.site.web;

import com.z5.zcms.admsys.common.domain.CommonUseVo;
import com.z5.zcms.admsys.common.service.CommonService;
import com.z5.zcms.admsys.site.domain.ZsiteVo;
import com.z5.zcms.admsys.site.service.ZsiteService;
import com.z5.zcms.admsys.validator.SiteValidator;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.SecuritySessionUtil;
import com.z5.zcms.util.ZPrint;
import egovframework.com.cmm.service.EgovProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.FileReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.z5.zcms.util.ZPrint.print;

@Controller
public class ZsiteController {
    private static final String    LICENSE_INQUIRY = "/zcms/admsys/license";
    private static final String    LICENSE_BEGIN   = "------------- LICENSE BEGIN ------------";
    private static final String    LICENSE_EXPIRY  = "expiry  date";
    private static final String    LICENSE_DOMAIN  = "host  domain";
    private static final String    LICENSE_IPADDR  = "host address";
    private static final String    LICENSE_TOKEN   = ":";
    private static final String    LICENSE_CLOSE   = "------------- LICENSE CLOSE ------------";
    private static final String    SIGNATURE_BEGIN = "------------ SIGNATURE BEGIN -----------";
    private static final String    SIGNATURE_CLOSE = "------------ SIGNATURE CLOSE -----------";
    /* Mapping table from 6-bit nibbles to Base64 characters.
    */
    private static final char[]    map1            = new char[64];
    /* Mapping table from Base64 characters to 6-bit nibbles.
    */
    private static final byte[]    map2            = new byte[128];
    private static final boolean   DEBUG_FLAG      = false;
    private static       Signature signature       = null;

    static {
        int i = 0;
        for (char c = 'A'; c <= 'Z'; c++)
            map1[i++] = c;
        for (char c = 'a'; c <= 'z'; c++)
            map1[i++] = c;
        for (char c = '0'; c <= '9'; c++)
            map1[i++] = c;
        map1[i++] = '+';
        map1[i] = '/';
    }

    static {
        for (int i = 0; i < map2.length; i++)
            map2[i] = -1;
        for (int i = 0; i < 64; i++)
            map2[map1[i]] = (byte) i;
    }

    @Autowired
    private SiteValidator siteValidator;
    @Autowired
    private ZsiteService  zsiteService;
    @Autowired
    private CommonService commonService;

    private static byte[] decodeKey(char[] in) {
        int len = in.length;
        if (len % 4 != 0)
            throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
        while (len > 0 && in[len - 1] == '=')
            len--;
        int    siz = (len * 3) / 4;
        byte[] out = new byte[siz];
        int    ip  = 0;
        int    op  = 0;
        while (ip < len) {
            int i0 = in[ip++];
            int i1 = in[ip++];
            int i2 = ip < len ? in[ip++] : 'A';
            int i3 = ip < len ? in[ip++] : 'A';
            if (i0 > 127 || i1 > 127 || i2 > 127 || i3 > 127)
                throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            int b0 = map2[i0];
            int b1 = map2[i1];
            int b2 = map2[i2];
            int b3 = map2[i3];
            if (b0 < 0 || b1 < 0 || b2 < 0 || b3 < 0)
                throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            int o0 = (b0 << 2) | (b1 >>> 4);
            int o1 = ((b1 & 0xf) << 4) | (b2 >>> 2);
            int o2 = ((b2 & 3) << 6) | b3;
            out[op++] = (byte) o0;
            if (op < siz)
                out[op++] = (byte) o1;
            if (op < siz)
                out[op++] = (byte) o2;
        }
        return out;
    }

    private static void error(String message) {
        if (DEBUG_FLAG) {
            String fullClassName = Thread.currentThread().getStackTrace()[2].getClassName();
            String className     = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
            //String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
            int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();

            System.out.println(String.format("[%15s %04d] Error, %s", className, lineNumber, message));
        }
    }

    private static boolean badAddress(String address) {
        try {
            for (Enumeration ifaces = NetworkInterface.getNetworkInterfaces(); ifaces.hasMoreElements(); ) {
                NetworkInterface iface = (NetworkInterface) ifaces.nextElement();
                for (Enumeration inetAddrs = iface.getInetAddresses(); inetAddrs.hasMoreElements(); ) {
                    InetAddress inetAddr = (InetAddress) inetAddrs.nextElement();
                    //if (!inetAddr.isLoopbackAddress() && inetAddr.getHostAddress().equals(address)) {
                    if (inetAddr.getHostAddress().equals(address)) {
                        return false;
                    }
                }
            }
        } catch (Exception ex) {
            error("Processing license : " + ex.getMessage());
        }

        return true;
    }

    private void initSignature() throws Exception {
        final String zfiveKey = "" +
            "MIIBuDCCASwGByqGSM44BAEwggEfAoGBAP1/U4Ed" +
            "dRIpUt9KnC7s5Of2EbdSPO9EAMMeP4C2USZpRV1A" +
            "IlH7WT2NWPq/xfW6MPbLm1Vs14E7gB00b/JmYLdr" +
            "mVClpJ+f6AR7ECLCT7up1/63xhv4O1fnxqimFQ8E" +
            "+4P208UewwI1VBNaFpEy9nXzrith1yrv8iIDGZ3R" +
            "SAHHAhUAl2BQjxUjC8yykrmCouuEC/BYHPUCgYEA" +
            "9+GghdabPd7LvKtcNrhXuXmUr7v6OuqC+VdMCz0H" +
            "gmdRWVeOutRZT+ZxBxCBgLRJFnEj6EwoFhO3zwky" +
            "jMim4TwWeotUfI0o4KOuHiuzpnWRbqN/C/ohNWLx" +
            "+2J6ASQ7zKTxvqhRkImog9/hWuWfBpKLZl6Ae1Ul" +
            "ZAFMO/7PSSoDgYUAAoGBAOCqZQ/TbLENM+7U4veh" +
            "mrf4SMctFgBFwhHu8F5phsCUFVqxwwEqmldsgbbc" +
            "ewZGBEq4OiW6bKkA0YvMr64Budn6AXhsPoMjAg+o" +
            "8SDa2d6ooPzgCVAuBTqjoiZ+5haHzYjQmvAMQIob" +
            "lHrPv2WwyQ2GElGNnePBGudJrLaST+JD";

        PublicKey publicKey;

        try {
            publicKey = KeyFactory.getInstance("DSA").generatePublic(new X509EncodedKeySpec(decodeKey(zfiveKey.toCharArray())));

            try {
                signature = Signature.getInstance("SHA1withDSA");
                signature.initVerify(publicKey);
            } catch (Exception ex) {
                System.out.println(Thread.currentThread().getStackTrace()[1] + " Error, signature validation - " + ex.getMessage());
                signature = null;
            }
        } catch (Exception ex) {
            System.out.println(Thread.currentThread().getStackTrace()[1] + " Error, public key - " + ex.getMessage());
            signature = null;
        }
    }

    /**
     * [copy site with post method]
     *
     * @param zsiteVo [description]
     * @param err     [description]
     * @param model   [description]
     * @param req     [description]
     * @return [description]
     * @throws Exception [description]
     */
    @Transactional
    @RequestMapping(value = "/admsys/inc/copysite.html", method = RequestMethod.POST)
    public String copySubmit(@ModelAttribute("zsiteVo") ZsiteVo zsiteVo,
                             BindingResult err, Model model, HttpServletRequest req) throws Exception {
        try {
            byte[]                  signatures = null;
            HashMap<String, String> parameters = new HashMap<String, String>();

            initSignature();

            FileReader     file = null;
            BufferedReader dump = null;
            boolean        find;
            try {
                file = new FileReader(EgovProperties.getPathProperty("Globals.cms.license"));
                dump = new BufferedReader(file);
                String data = "";
                String line;

                find = false;
                while (dump.ready() && !find) {
                    line = dump.readLine();
                    if (line.equals(LICENSE_BEGIN)) {
                        find = true;
                    }
                }

                while (dump.ready() && find) {
                    line = dump.readLine();
                    if (!line.equals(LICENSE_CLOSE)) {
                        int index = line.indexOf(LICENSE_TOKEN);
                        if (index != -1 && index + 1 <= line.length()) {
                            parameters.put(line.substring(0, index).trim(), line.substring(index + 1).trim());
                        }
                        signature.update(line.getBytes(), 0, line.getBytes().length);
                    } else {
                        find = false;
                    }
                }

                find = false;
                while (dump.ready() && !find) {
                    line = dump.readLine();
                    if (line.equals(SIGNATURE_BEGIN)) {
                        find = true;
                    }
                }

                while (dump.ready() && find) {
                    line = dump.readLine();
                    if (line.equals(SIGNATURE_CLOSE)) {
                        find = false;
                    } else {
                        data += line;
                    }
                }

                signatures = decodeKey(data.toCharArray());
            } catch (Exception ex) {
                error("processing license : " + ex.getMessage());
            } finally {
                try {
                    assert dump != null;
                    dump.close();
                    file.close();
                } catch (Exception ignored) {
                }
            }

            if (signature != null && signature.verify(signatures)) {
                String expiry = parameters.get(LICENSE_EXPIRY);
                String domain = parameters.get(LICENSE_DOMAIN);

                SimpleDateFormat formatter  = new SimpleDateFormat("yyyy-MM-dd");
                Date             actualDate = new Date();
                Date             expiryDate = formatter.parse(expiry);
                if (!actualDate.before(expiryDate)) {
                    error("license timeout!");
                    return LICENSE_INQUIRY;
                }

                if (badAddress(parameters.get(LICENSE_IPADDR))) {
                    return LICENSE_INQUIRY;
                }

                final String siteDomain = req.getServerName().replaceFirst("www.", "").trim().replaceAll(" ", "").toLowerCase();
                if (siteDomain.contains(domain)) {
                    siteValidator.validate(zsiteVo, err);
                    model.addAttribute("flag", false);

                    zsiteVo.setSitedomain(zsiteVo.getSitedomain().trim().replaceAll(" ", "").toLowerCase());
                    zsiteVo.setSitetitle(zsiteVo.getSitetitle().trim().replaceAll(",", "&#44;"));

                    error("vo = " + zsiteVo.toString());
                    int maxNumber = zsiteService.copy(zsiteVo);
                    error("max = " + maxNumber);

                    List<String> useTables = commonService.getUseTbl();

                    final List<CommonUseVo> dataList = new ArrayList<CommonUseVo>();

                    for (final String table : useTables) {
                        CommonUseVo commonUseVo = new CommonUseVo();
                        commonUseVo.setTable(table);
                        commonUseVo.setNo(maxNumber);
                        commonUseVo.setSiteno(zsiteVo.getSiteno());
                        commonUseVo.setSitetitle(zsiteVo.getSitetitle());
//                        commonUseVo.setKeyname(table.substring(1, table.length() - 3) + "no");
                        commonUseVo.setUserid(SecuritySessionUtil.getUserid(req));
                        if (table.equals("zcssuse") || table.equals("zjsuse") || table.equals("ztpluse")) {
                            commonUseVo.setMenuno(-1);
                        }
                        dataList.add(commonUseVo);
                    }

                    commonService.batchInsert(dataList);
                    model.addAttribute("flag", true);

                    return "/zcms/admsys/inc/copysite";
                } else {
                    error("mismatched domain!");
                    return LICENSE_INQUIRY;
                }
            }
        } catch (Exception ex) {
            error("verifying license : " + ex.getMessage());
            ex.printStackTrace();
        }

        return LICENSE_INQUIRY;
    }

    /**
     * [copy site with get method]
     *
     * @param zsiteVo [description]
     * @param model   [description]
     * @return [description]
     * @throws Exception [description]
     */
    @RequestMapping(value = "/admsys/inc/copysite.html", method = RequestMethod.GET)
    public String copyView(@ModelAttribute("zsiteVo") ZsiteVo zsiteVo, Model model, HttpServletRequest req) throws Exception {
        try {
            byte[]                  signatures = null;
            HashMap<String, String> parameters = new HashMap<String, String>();

            initSignature();

            String         line;
            boolean        flag = false;
            FileReader     file = null;
            BufferedReader data = null;
            try {
                file = new FileReader(EgovProperties.getPathProperty("Globals.cms.license"));
                data = new BufferedReader(file);

                found:
                while (data.ready()) {
                    if (data.readLine().equals(LICENSE_BEGIN)) {
                        while (data.ready()) {
                            line = data.readLine();
                            if (line.equals(LICENSE_CLOSE)) {
                                flag = true;
                                break found;
                            }

                            signature.update(line.getBytes(), 0, line.getBytes().length);
                            int index = line.indexOf(LICENSE_TOKEN);
                            if (index != -1 && index + 1 <= line.length()) {
                                parameters.put(line.substring(0, index).trim(), line.substring(index + 1).trim());
                            }
                        }
                    }
                }
                if (flag) {
                    flag = false;
                    while (data.ready() && !flag) {
                        line = data.readLine();
                        if (line.equals(SIGNATURE_BEGIN)) {
                            flag = true;
                        }
                    }

                    String buffer = "";
                    while (data.ready() && flag) {
                        line = data.readLine();
                        if (line.equals(SIGNATURE_CLOSE)) {
                            flag = false;
                        } else {
                            buffer += line;
                        }
                    }

                    signatures = decodeKey(buffer.toCharArray());
                }
            } catch (Exception ex) {
                error("processing license : " + ex.getMessage());
            } finally {
                try {
                    assert data != null;
                    data.close();
                    file.close();
                } catch (Exception ignored) {
                }
            }

            if (signature != null && signature.verify(signatures)) {
                final String domain = req.getServerName().replaceFirst("www.", "").trim().replaceAll(" ", "").toLowerCase();
                if (!domain.contains(parameters.get(LICENSE_DOMAIN))) {
                    return LICENSE_INQUIRY;
                }

                if (badAddress(parameters.get(LICENSE_IPADDR))) {
                    return LICENSE_INQUIRY;
                }

                SimpleDateFormat formatter  = new SimpleDateFormat("yyyy-MM-dd");
                Date             actualDate = new Date();
                Date             expiryDate = formatter.parse(parameters.get(LICENSE_EXPIRY));
                if (!actualDate.before(expiryDate)) {
                    return LICENSE_INQUIRY;
                }

                final ZsiteVo detail = zsiteService.selectbypk(zsiteVo);
                model.addAttribute("detail", detail);
                return "/zcms/admsys/inc/copysite";
            }
        } catch (Exception ex) {
            error("should verify license : " + ex.getMessage());
        }

        return LICENSE_INQUIRY;
    }

    /**
     * [delete site]
     *
     * @param siteno  [description]
     * @param zsiteVo [description]
     * @param err     [description]
     * @return [description]
     * @throws Exception [description]
     */
    @RequestMapping("/admsys/site/site/delete.html")
    public String delete(@RequestParam("siteno") String[] siteno,
                         @ModelAttribute("zsiteVo") ZsiteVo zsiteVo, BindingResult err, HttpServletRequest req) throws Exception {
        initSignature();

        byte[]                  signatures = null;
        HashMap<String, String> parameters = new HashMap<String, String>();

        boolean        find;
        FileReader     file = null;
        BufferedReader data = null;
        try {
            file = new FileReader(EgovProperties.getPathProperty("Globals.cms.license"));
            data = new BufferedReader(file);
            String line;

            find = false;
            while (data.ready() && !find) {
                line = data.readLine();
                if (line.equals(LICENSE_BEGIN)) {
                    find = true;
                }
            }
            while (data.ready() && find) {
                line = data.readLine();
                if (!line.equals(LICENSE_CLOSE)) {
                    signature.update(line.getBytes(), 0, line.getBytes().length);
                    int index = line.indexOf(LICENSE_TOKEN);
                    if (index != -1 && index + 1 <= line.length()) {
                        parameters.put(line.substring(0, index).trim(), line.substring(index + 1).trim());
                    }
                } else {
                    find = false;
                }
            }

            find = false;
            while (data.ready() && !find) {
                line = data.readLine();
                if (line.equals(SIGNATURE_BEGIN)) {
                    find = true;
                }
            }

            String buffer = "";
            while (data.ready() && find) {
                line = data.readLine();
                if (line.equals(SIGNATURE_CLOSE)) {
                    find = false;
                } else {
                    buffer += line;
                }
            }

            signatures = decodeKey(buffer.toCharArray());
        } catch (Exception ex) {
            error("processing license : " + ex.getMessage());
        } finally {
            try {
                assert data != null;
                data.close();
                file.close();
            } catch (Exception ignored) {
            }
        }

        if (signature != null && signature.verify(signatures)) {
            SimpleDateFormat formatter  = new SimpleDateFormat("yyyy-MM-dd");
            Date             actualDate = new Date();
            Date             expiryDate = formatter.parse(parameters.get(LICENSE_EXPIRY));

            if (!actualDate.before(expiryDate)) {
                return LICENSE_INQUIRY;
            }

            if (badAddress(parameters.get(LICENSE_IPADDR))) {
                return LICENSE_INQUIRY;
            }

            final String domain = req.getServerName().replaceFirst("www.", "").trim().replaceAll(" ", "").toLowerCase();
            if (domain.contains(parameters.get(LICENSE_DOMAIN))) {
                siteValidator.validate(zsiteVo, err);

                String nos = "";
                for (int i = 0; i < siteno.length; i++) {
                    if (i > 0) {
                        nos += ",";
                    }
                    nos += siteno[i].split("\\^")[0];
                }

                ArrayList<String>   tableList = (ArrayList<String>) commonService.getUseTbl();
                final List<ZsiteVo> dataList  = new ArrayList<ZsiteVo>();

                tableList.add("zsite");
                tableList.add("zsitecfg");
                tableList.add("zmenu");
                tableList.add("zmenuhis");
                //tableList.add("zcssuse");
                //tableList.add("zjsuse");
                //tableList.add("ztpluse");
                tableList.add("zmain");
                tableList.add("zmainhis");
                for (final String table : tableList) {
                    zsiteVo = new ZsiteVo();
                    zsiteVo.setTable(table);
                    zsiteVo.setNos(nos);
                    dataList.add(zsiteVo);
                }
                zsiteService.batchDelete(dataList);

                return "redirect:/admsys/site/site/index.html";
            }
        }

        return LICENSE_INQUIRY;
    }

    /**
     * [insertSubmit: insert site with post method]
     *
     * @param zsiteVo [description]
     * @param err     [description]
     * @return [description]
     * @throws Exception [description]
     */
    @RequestMapping(value = "/admsys/site/site/insert.html", method = RequestMethod.POST)
    public String insertSubmit(@ModelAttribute("zsiteVo") ZsiteVo zsiteVo, BindingResult err, HttpServletRequest req) throws Exception {
        byte[]                  signatures = null;
        HashMap<String, String> parameters = new HashMap<String, String>();
        FileReader              file       = null;
        BufferedReader          data       = null;
        boolean                 find;

        initSignature();

        try {
            file = new FileReader(EgovProperties.getPathProperty("Globals.cms.license"));
            data = new BufferedReader(file);

            find = false;
            while (data.ready()) {
                if (data.readLine().equals(LICENSE_BEGIN)) {
                    find = true;
                    break;
                }
            }
            if (find) {
                String line;
                find = false;
                while (data.ready() && !find) {
                    line = data.readLine();
                    if (!line.equals(LICENSE_CLOSE)) {
                        signature.update(line.getBytes(), 0, line.getBytes().length);
                        int index = line.indexOf(LICENSE_TOKEN);
                        if (index != -1 && index + 1 <= line.length()) {
                            parameters.put(line.substring(0, index).trim(), line.substring(index + 1).trim());
                        }
                    } else {
                        find = true;
                    }
                }

                String buffer = "";
                find = false;
                while (data.ready() && !find) {
                    line = data.readLine();
                    if (line.equals(SIGNATURE_BEGIN)) {
                        find = true;
                    }
                }

                while (data.ready() && find) {
                    line = data.readLine();
                    if (line.equals(SIGNATURE_CLOSE)) {
                        find = false;
                    } else {
                        buffer += line;
                    }
                }

                signatures = decodeKey(buffer.toCharArray());
            }
        } catch (Exception ex) {
            error("processing license : " + ex.getMessage());
        } finally {
            try {
                assert data != null;
                data.close();
                file.close();
            } catch (Exception ignored) {
            }
        }

        if (signature != null && signature.verify(signatures)) {
            SimpleDateFormat formatter  = new SimpleDateFormat("yyyy-MM-dd");
            Date             actualDate = new Date();
            Date             expiryDate = formatter.parse(parameters.get(LICENSE_EXPIRY));
            if (!actualDate.before(expiryDate)) {
                return LICENSE_INQUIRY;
            }

            if (badAddress(parameters.get(LICENSE_IPADDR))) {
                return LICENSE_INQUIRY;
            }

            final String domain = req.getServerName().replaceFirst("www.", "").trim().replaceAll(" ", "").toLowerCase();
            if (domain.contains(parameters.get(LICENSE_DOMAIN))) {
                siteValidator.validate(zsiteVo, err);

                try {
                    zsiteVo.setSitedomain(zsiteVo.getSitedomain().replaceAll(" ", "").toLowerCase());
                    zsiteVo.setSitetitle(zsiteVo.getSitetitle().trim().replaceAll(",", "&#44;"));
                    zsiteVo.setSitewebtitle(zsiteVo.getSitewebtitle().trim());
                    zsiteService.insert(zsiteVo);
                } catch (final Exception e) {
                    e.printStackTrace();
                }

                return "redirect:/admsys/site/site/index.html";
            }
        }

        return LICENSE_INQUIRY;
    }

    /**
     * [insertView: insert site with get method]
     *
     * @return [description]
     * @throws Exception [description]
     */
    @RequestMapping(value = "/admsys/site/site/insert.html", method = RequestMethod.GET)
    public String insertView() throws Exception {
        initSignature();

        FileReader              file       = null;
        BufferedReader          data       = null;
        byte[]                  signatures = null;
        HashMap<String, String> parameters = new HashMap<String, String>();

        try {
            file = new FileReader(EgovProperties.getPathProperty("Globals.cms.license"));
            data = new BufferedReader(file);
            if (!data.ready()) {
                return LICENSE_INQUIRY;
            }

            String  line;
            boolean find = false;
            while (data.ready() && !find) {
                line = data.readLine();
                if (line.equals(LICENSE_BEGIN)) {
                    find = true;
                }
            }
            while (data.ready() && find) {
                line = data.readLine();
                if (line.equals(LICENSE_CLOSE)) {
                    break;
                }
                signature.update(line.getBytes(), 0, line.getBytes().length);
                int index = line.indexOf(LICENSE_TOKEN);
                if (index != -1 && index + 1 <= line.length()) {
                    parameters.put(line.substring(0, index).trim(), line.substring(index + 1).trim());
                }
            }

            find = false;
            while (data.ready() && !find) {
                line = data.readLine();
                if (line.equals(SIGNATURE_BEGIN)) {
                    find = true;
                }
            }

            String buffer = "";
            while (data.ready() && find) {
                line = data.readLine();
                if (line.equals(SIGNATURE_CLOSE)) {
                    find = false;
                } else {
                    buffer += line;
                }
            }

            signatures = decodeKey(buffer.toCharArray());
        } catch (Exception ex) {
            error("processing license : " + ex.getMessage());
        } finally {
            try {
                assert data != null;
                data.close();
                file.close();
            } catch (Exception ignored) {
            }
        }

        try {
            if (signature != null && signature.verify(signatures)) {
                SimpleDateFormat formatter  = new SimpleDateFormat("yyyy-MM-dd");
                Date             actualDate = new Date();
                Date             expiryDate = formatter.parse(parameters.get(LICENSE_EXPIRY));

                if (!actualDate.before(expiryDate)) {
                    return LICENSE_INQUIRY;
                }

                if (badAddress(parameters.get(LICENSE_IPADDR))) {
                    return LICENSE_INQUIRY;
                }

                return "/zcms/admsys/site/site/insert";
            }
        } catch (Exception ignored) {
        }

        return LICENSE_INQUIRY;
    }

    @RequestMapping(value = {"admsys/site/site/", "admsys/site/site/index.html"})
    public String selectZsiteList(@ModelAttribute("zsiteVo") ZsiteVo zsiteVo,
                                  @RequestParam(value = "mode", required = false) String mode,
                                  @RequestParam(value = "act", required = false) String act,
                                  Model model, HttpServletRequest req) throws Exception {

        initSignature();

        byte[]                  signatures = null;
        HashMap<String, String> parameters = new HashMap<String, String>();

        boolean        find;
        FileReader     file = null;
        BufferedReader data = null;
        try {
            file = new FileReader(EgovProperties.getPathProperty("Globals.cms.license"));
            data = new BufferedReader(file);
            if (!data.ready()) {
                error("could not open license file!");
                return LICENSE_INQUIRY;
            }

            String line;
            find = false;
            while (data.ready() && !find) {
                line = data.readLine();
                if (line.equals(LICENSE_BEGIN)) {
                    find = true;
                }
            }
            while (data.ready() && find) {
                line = data.readLine();
                if (line.equals(LICENSE_CLOSE)) {
                    break;
                } else {
                    signature.update(line.getBytes(), 0, line.getBytes().length);
                    int index = line.indexOf(LICENSE_TOKEN);
                    if (index != -1 && index + 1 <= line.length()) {
                        parameters.put(line.substring(0, index).trim(), line.substring(index + 1).trim());
                    }
                }
            }

            finish:
            while (data.ready()) {
                line = data.readLine();
                if (line.equals(SIGNATURE_BEGIN)) {
                    String buffer = "";
                    while (data.ready()) {
                        line = data.readLine();
                        if (line.equals(SIGNATURE_CLOSE)) {
                            signatures = decodeKey(buffer.toCharArray());
                            break finish;
                        } else {
                            buffer += line;
                        }
                    }
                }
            }
        } catch (Exception ex) {
            error(Thread.currentThread().getStackTrace()[1] + " license - " + ex.getMessage());
            return LICENSE_INQUIRY;
        } finally {
            try {
                assert data != null;
                data.close();
                file.close();
            } catch (Exception ignored) {
            }
        }

        if (signature != null && signature.verify(signatures)) {
            SimpleDateFormat formatter  = new SimpleDateFormat("yyyy-MM-dd");
            Date             actualDate = new Date();
            Date             expiryDate = formatter.parse(parameters.get(LICENSE_EXPIRY));

            if (!actualDate.before(expiryDate)) {
                error(" Invalid license time!");
                return LICENSE_INQUIRY;
            }

            if (badAddress(parameters.get(LICENSE_IPADDR))) {
                return LICENSE_INQUIRY;
            }

            final String domain = req.getServerName().replaceFirst("www.", "").trim().replaceAll(" ", "").toLowerCase();
            if (domain.contains(parameters.get(LICENSE_DOMAIN))) {
                try {
                    if (null != mode) {
                        Map<String, String> map = new HashMap<String, String>();
                        map.put("siteorder", String.valueOf(zsiteVo.getSiteorder()));
                        map.put("func", act.equals("down") ? "MAX" : "MIN");
                        map.put("mark", act.equals("down") ? "<" : ">");

                        int swapNum = zsiteService.siteSwapNum(map);

                        if (swapNum > 0) {
                            map.put("swapNum", String.valueOf(swapNum));
                            zsiteService.siteOrder(map);
                        }
                    }

                    final DataTable input = new DataTable(req);

                    final int pageSize = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));
                    if (input.getInt("pageIndex") == 0)
                        input.put("pageIndex", 1);
                    final int    pageIndex  = input.getInt("pageIndex") - 1;
                    final String sdate      = input.get("sdate").replace("-", "");
                    final String edate      = input.get("edate").replace("-", "");
                    final String keyword    = input.get("keyword");
                    final String sitestatus = input.get("sitestatus");

                    if (sdate.equals("") && edate.equals(""))
                        zsiteVo.setCond1("");
                    else
                        zsiteVo.setCond1(input.get("cond1"));
                    if (keyword.equals(""))
                        zsiteVo.setCond2("");
                    else
                        zsiteVo.setCond2(input.get("cond2"));
                    if (sitestatus.equals(""))
                        zsiteVo.setSitestatus("");
                    else
                        zsiteVo.setSitestatus(input.get("sitestatus"));

                    zsiteVo.setSdate(sdate);
                    zsiteVo.setEdate(edate);
                    zsiteVo.setKeyword(input.get("keyword"));
                    zsiteVo.setM(pageIndex * pageSize);
                    zsiteVo.setN(pageSize);

                    final int total = zsiteService.listCount(zsiteVo);
                    input.put("pageSize", pageSize);
                    input.put("total", total);
                    input.put("pageMax", (int) Math.ceil((double) total / pageSize));

                    final List<ZsiteVo> list = zsiteService.getList(zsiteVo);

                    model.addAttribute("list", list);
                    model.addAttribute("input", input);
                    //security session test
                    /*
                    SecuritySessionUtil.toString(req);
                    System.out.println("SecuritySessionUtil.getUserid(req) : "+SecuritySessionUtil.getUserid(req));
                    SecuritySessionUtil.getAuths(req);
                    System.out.println("ROLE_ADMIN:"+ SecuritySessionUtil.isAuth(req, "ROLE_ADMIN"));
                    System.out.println("ROLE_USER:"+SecuritySessionUtil.isAuth(req, "ROLE_USER"));
                    System.out.println("ROLE_user:"+SecuritySessionUtil.isAuth(req, "ROLE_user"));
                    */
                } catch (Exception ex) {
                    error("license - " + ex.getMessage());
                }

                return "/zcms/admsys/site/site/index";
            } else {
                error("Invalid license domain! '" + domain + "'");
            }
        }

        return LICENSE_INQUIRY;
    }

    /**
     * [updateSubmit: update site with post method]
     *
     * @param zsiteVo [description]
     * @param req     [description]
     * @return [description]
     * @throws Exception [description]
     */
    @RequestMapping(value = "/admsys/site/site/update.html", method = RequestMethod.POST)
    public String updateSubmit(@ModelAttribute("zsiteVo") ZsiteVo zsiteVo, HttpServletRequest req) throws Exception {
        String                  line;
        FileReader              file       = null;
        BufferedReader          data       = null;
        byte[]                  signatures = null;
        HashMap<String, String> parameters = new HashMap<String, String>();

        initSignature();
        try {
            file = new FileReader(EgovProperties.getPathProperty("Globals.cms.license"));
            data = new BufferedReader(file);

            done:
            while (data.ready()) {
                line = data.readLine();
                if (line.equals(LICENSE_BEGIN)) {
                    while (data.ready()) {
                        line = data.readLine();
                        if (!line.equals(LICENSE_CLOSE)) {
                            signature.update(line.getBytes(), 0, line.getBytes().length);
                            int index = line.indexOf(LICENSE_TOKEN);
                            if (index != -1 && index + 1 <= line.length()) {
                                parameters.put(line.substring(0, index).trim(), line.substring(index + 1).trim());
                            }
                        } else {
                            break done;
                        }
                    }
                    break;
                }
            }

            boolean finish = false;
            while (data.ready() && !finish) {
                line = data.readLine();
                if (line.equals(SIGNATURE_BEGIN)) {
                    finish = true;
                }
            }

            String buffer = "";
            while (data.ready() && finish) {
                line = data.readLine();
                if (line.equals(SIGNATURE_CLOSE)) {
                    signatures = decodeKey(buffer.toCharArray());
                    break;
                } else {
                    buffer += line;
                }
            }
        } catch (Exception ex) {
            error("processing license : " + ex.getMessage());
        } finally {
            try {
                assert data != null;
                data.close();
                file.close();
            } catch (Exception ignored) {
            }
        }

        if (signature != null && signature.verify(signatures)) {
            SimpleDateFormat formatter  = new SimpleDateFormat("yyyy-MM-dd");
            Date             actualDate = new Date();
            Date             expiryDate = formatter.parse(parameters.get(LICENSE_EXPIRY));
            if (!actualDate.before(expiryDate)) {
                return LICENSE_INQUIRY;
            }

            if (badAddress(parameters.get(LICENSE_IPADDR))) {
                return LICENSE_INQUIRY;
            }

            final String domain = req.getServerName().replaceFirst("www.", "").trim().replaceAll(" ", "").toLowerCase();
            if (!domain.contains(parameters.get(LICENSE_DOMAIN))) {
                return LICENSE_INQUIRY;
            }

            try {
                ZPrint.print(zsiteVo.toString());
                zsiteVo.setSitedomain(zsiteVo.getSitedomain().trim().replaceAll(" ", "").toLowerCase());
                zsiteVo.setSitetitle(zsiteVo.getSitetitle().trim().replaceAll("&#44;", ","));
                zsiteVo.setSitewebtitle(zsiteVo.getSitewebtitle().trim());

                zsiteService.update(zsiteVo);

                List<String>      useTables = commonService.getUseTbl();
                List<CommonUseVo> dataList  = new ArrayList<CommonUseVo>();

                for (final String table : useTables) {
                    CommonUseVo commonUseVo = new CommonUseVo();
                    commonUseVo.setTable(table);
                    commonUseVo.setSiteno(zsiteVo.getSiteno());
                    commonUseVo.setSitetitle(zsiteVo.getSitetitle());
                    commonUseVo.setUserid(SecuritySessionUtil.getUserid(req));
                    dataList.add(commonUseVo);
                }

                commonService.batchUpdate(dataList);
            } catch (final Exception e) {
                e.printStackTrace();
            }

            return "redirect:/admsys/site/site/index.html";
        }

        return LICENSE_INQUIRY;
    }

    /**
     * [updateView: update site with get method]
     *
     * @param zsiteVo [description]
     * @param model   [description]
     * @return [description]
     * @throws Exception [description]
     */
    @RequestMapping(value = "/admsys/site/site/update.html", method = RequestMethod.GET)
    public String updateView(@ModelAttribute("zsiteVo") ZsiteVo zsiteVo, Model model, HttpServletRequest req) throws Exception {
        String         line;
        FileReader     file = null;
        BufferedReader data = null;

        initSignature();

        byte[]                  signatures = null;
        HashMap<String, String> parameters = new HashMap<String, String>();
        try {
            file = new FileReader(EgovProperties.getPathProperty("Globals.cms.license"));
            data = new BufferedReader(file);

            finish:
            while (data.ready()) {
                if (data.readLine().equals(LICENSE_BEGIN)) {
                    while (data.ready()) {
                        line = data.readLine();
                        if (line.equals(LICENSE_CLOSE)) {
                            while (data.ready()) {
                                if (data.readLine().equals(SIGNATURE_BEGIN)) {
                                    String buffer = "";
                                    while (data.ready()) {
                                        line = data.readLine();
                                        if (line.equals(SIGNATURE_CLOSE)) {
                                            signatures = decodeKey(buffer.toCharArray());
                                            break finish;
                                        } else {
                                            buffer += line;
                                        }
                                    }
                                    break;
                                }
                            }
                            break finish;
                        } else {
                            signature.update(line.getBytes(), 0, line.getBytes().length);
                            int index = line.indexOf(LICENSE_TOKEN);
                            if (index != -1 && index + 1 <= line.length()) {
                                parameters.put(line.substring(0, index).trim(), line.substring(index + 1).trim());
                            }
                        }
                    }
                    break;
                }
            }
        } catch (Exception ex) {
            error("processing license : " + ex.getMessage());
        } finally {
            try {
                assert data != null;
                data.close();
                file.close();
            } catch (Exception ignored) {
            }
        }

        if (signature != null && signature.verify(signatures)) {
            SimpleDateFormat formatter  = new SimpleDateFormat("yyyy-MM-dd");
            Date             actualDate = new Date();
            Date             expiryDate = formatter.parse(parameters.get(LICENSE_EXPIRY));

            if (!actualDate.before(expiryDate)) {
                return LICENSE_INQUIRY;
            }

            if (badAddress(parameters.get(LICENSE_IPADDR))) {
                return LICENSE_INQUIRY;
            }

            final String domain = req.getServerName().replaceFirst("www.", "").trim().replaceAll(" ", "").toLowerCase();
            if (domain.contains(parameters.get(LICENSE_DOMAIN))) {
                model.addAttribute("detail", zsiteService.selectbypk(zsiteVo));
                return "/zcms/admsys/site/site/update";
            }
        }

        return LICENSE_INQUIRY;
    }
}
