package com.z5.zcms.frontsys.search.web;


import com.z5.zcms.admsys.board.domain.ZBoardVo;
import com.z5.zcms.admsys.board.service.FrontBoardService;
import com.z5.zcms.frontsys.search.service.FrontSearchService;
import com.z5.zcms.util.DataTable;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.z5.zcms.util.ZPrint.*;

@Controller
@RequestMapping(value = "/search/front")
public class FrontSearchController {
    @Autowired
    FrontBoardService frontBoardService;
    private Logger log = Logger.getLogger(this.getClass());
    @Autowired
    private FrontSearchService frontSearchService;

    @RequestMapping(value = "/list.html")
    public String list(Model model, HttpServletRequest request, HttpSession session) {

        enter();
        param(request);
        DataTable input = new DataTable(request);

        try {

            String keyword = input.get("keyword");
            print("keyword : " + keyword);

            ZBoardVo       zBoardVo  = new ZBoardVo();
            List<ZBoardVo> zboardList = frontBoardService.getAllBoard(zBoardVo);

            for (int ndx = 0; ndx < zboardList.size(); ++ndx) {
                if (keyword.equals("")) {
                    zBoardVo.setCond2("");
                } else {
                    zBoardVo.setCond2(input.get("cond2"));
                    zBoardVo.setKeyword(keyword.trim());
                }

                if (!input.get("cond3").equals("")) {
                    if (input.get("cond3").equals("5")) {
                        zBoardVo.setSdate(input.get("sdate").replace("-", ""));
                        zBoardVo.setEdate(input.get("edate").replace("-", ""));
                    }
                    zBoardVo.setCond3(input.get("cond3"));
                }

                if (!input.get("cond1").equals("")) {
                    zBoardVo.setCond1(input.get("cond1"));
                }

                zBoardVo.setTblname(zboardList.get(ndx).getTblname());
                zboardList.get(ndx).setBoardlist(frontBoardService.listAll(zBoardVo));

            }

            model.addAttribute("zboardList", zboardList);
            model.addAttribute("input", input);

        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }

        return "/zcms/frontsys/search/list";
    }


	/*@RequestMapping(value = "/list.html")
    public String paperList(
			@ModelAttribute("frontSearchVO") FrontSearchVO frontSearchVO,
			Model model,
			HttpServletRequest request,
			HttpSession session
			) {

		try{

			DataTable input = new DataTable(request);

			//url 변수명들
			String baseUrl = "";
			String leftUrl = "";
			String leftUrl2 = "";
			String totalUrl = "";

			String page = Integer.toString(input.getInt("pageIndex"));

			//System.out.println("pageIndex----->"+page);

			if (page.equals("0")){
				page = "1";
			}

			//페이징 변수들
			int total = 0;  //전체결과개수 totcnt
			int pageSize = 0; //요청개수 maxcnt
			String pageIndex = page; //페이지번호 pagenum

			//xml 파마리터 변수명들
			String msort = input.get("msort");;
			String outmax = "";  //전달 받고자 하는 검색 결과 수. 지정하지 않으면 각 section별로 지정된 default 값이 적용됨.  outmax=3
			String section = ""; //cate(문헌DB+) : 문헌DB경우는 현재 pub_id값이 924, 925, 1731만 존재하여 3분류만 그룹핑하여 출력하고있음
			String csq = "";   // title, author, keyword 검색 csq={title:국토} utf-8로 인코딩해야함
			String p1 = "";
			String d1 = "";
			String query = "";


			//왼쪽 리스트 클릭 및 정렬 변수
			String pub_id = input.get("pub_id");  //저널구분코드(pub_id)
			String yearMonth = input.get("yearMonth"); //논문 수록된 저널 출간년도
			String author = input.get("author"); //저자검색
			String sort = input.get("sort"); //저자검색
			String detailCon = input.get("csq");
			String csq_temp = "";
			String ym_temp= input.get("ym_temp"); //출간년도 기간
			String pub_temp= input.get("pub_temp"); //저널구분코드
			String showSize= input.get("showSize"); //화면에 보여줄 리스트 갯수



			//System.out.println("pub_id--->"+pub_id);
			//System.out.println("yearMonth--->"+yearMonth);
			//System.out.println("author--->"+author);
			//System.out.println("sort--->"+sort);

			//상세검색
			String keyword =  input.get("keyword"); // 키워드 전체검색일경우는 *

			String searchType = input.get("searchType");  //검색 타입 > base:기본검색 , detail:상세검색, left: 왼쪽검색

			String dTotal = input.get("dTotal"); //상세전체
			String dSubject = input.get("dSubject"); //제목
			String dAuthor = input.get("dAuthor"); //저자
			String dJournal = input.get("dJournal"); //학술지(pub_id)
			String dKeyword = input.get("dKeyword"); //키워드
			String sYear = input.get("sYear"); //시작년
			String sMonth = input.get("sMonth"); //시작월
			String eYear = input.get("eYear"); //종료년
			String eMonth = input.get("eMonth"); //종료월

			//System.out.println("dSubject--->"+dSubject);
			//System.out.println("dAuthor--->"+dAuthor);
			//System.out.println("dJournal--->"+dJournal);
			//System.out.println("dKeyword--->"+dKeyword);

			//빈공간이면 전체검색
			query = keyword;

			if (query.equals("")){
				query = "*";
			}else{
				query = "*"+query.replace(" ", "*")+"*";
			}

			//System.out.println("query====>"+query);

			//페이지 갯수 정의
			outmax = showSize;

			if(outmax.equals("")){
				outmax = "8";
			}


			//통합검색 부분
			if(searchType.equals("detail")){

				query = dTotal; //상세검색일경우 상세검색의 전체필드를 넣는다.

				if (query.equals("")){
					query = "*";
				}else{
					query = "*"+query.replace(" ", "*")+"*";
				}
				//System.out.println("query====>"+query);

				if(!dSubject.equals("")){
					csq = "{title:"+URLEncoder.encode(dSubject,"UTF-8")+"}";
				}

				if(!dAuthor.equals("")){

					if(!csq.equals("")){
						csq += URLEncoder.encode(" | ","UTF-8");
					}

					csq += "{author:"+URLEncoder.encode(dAuthor,"UTF-8")+"}";

				}

				if(!dKeyword.equals("")){

					if(!csq.equals("")){
						csq += URLEncoder.encode(" | ","UTF-8");
					}

					csq += "{keyword:"+URLEncoder.encode(dKeyword,"UTF-8")+"}";

				}

				if(!dJournal.equals("")){
					p1 = dJournal;
					pub_temp = dJournal;
				}

				if(!sYear.equals("")){
					d1 = sYear+sMonth+"~"+eYear+eMonth;
					ym_temp = d1;
				}

				//System.out.println("csq====>"+csq);
				//System.out.println("p1====>"+p1);
				//System.out.println("d1====>"+d1);
			}


			//csq가 지정되어 있느면 넣는다.
			if(!detailCon.equals("")){
				csq = detailCon;
			}

			//학술정보지가 지정되어 있으면 넣는다.
			if(!pub_temp.equals("")){
				p1 = pub_temp;
			}

			//년도가 지정되어 있으면 넣는다.
			if(!ym_temp.equals("")){
				d1 = ym_temp;
			}

			//파라미터로 넘기기 위한 변수저장 csq
			csq_temp = csq;

//			baseUrl = "http://115.71.232.2:7578/srch_resultxml";
//			baseUrl = "http://127.0.0.1:7578/srch_resultxml";


			baseUrl = EgovProperties.getProperty("Globals.search.url");


			//왼쪽 리스트(문헌DB+, 년도) URL
			leftUrl = baseUrl+"?w=total&q="+URLEncoder.encode(query,"UTF-8")+"&p1="+p1+"&d1="+d1+"&outmax=&section="+section+"&base64=Y&groups=1,2&onlycount=Y&csq="+csq;

			//왼쪽 리스트(저자)URL
			leftUrl2 = baseUrl+"?w=total_author_group&q="+URLEncoder.encode(query,"UTF-8")+"&p1="+p1+"&d1="+d1+"&outmax=&section="+section+"&base64=Y&groups=3&onlycount=Y&csq="+csq;


			//왼쪽 리스트 클릭했을때 (왼쪽 클릭시에는 통합검색만 보여주면 되므로 이쪽에 if문을 둔다.)
			if(searchType.equals("left")){

				//문헌db+ 검색
				if(!pub_id.equals("")){
					p1 = pub_id;
				}

				 //년도 검색
				if(!yearMonth.equals("")){
					d1 = yearMonth+"01~"+yearMonth+"12";
				}

				//저자검색
				if(!author.equals("")){

					if(!detailCon.equals("")){
						if(dAuthor.equals("")){ //상세검색일 경우에는 넣지 않는다.
							csq += URLEncoder.encode(" & ","UTF-8");
							csq += "{author:"+URLEncoder.encode(author,"UTF-8")+"}";
						}
					}else{
						csq = "{author:"+URLEncoder.encode(author,"UTF-8")+"}";
					}
				}

			}

			//정확도순 정렬일때
			if(sort.equals("m")){

				if(msort.indexOf("m:1:1") != -1){ //기존에 정확도순일때 비정확도순으로 변경
					msort = msort.replace("m:1:1", "m:1:0");
				}else if(msort.indexOf("m:1:0") != -1){ //기존에 비정확도순일때 초기화
					msort = msort.replace("m:1:0", "");
				}else{
					msort = "m:1:1";  //정확도순으로 정렬 추가
				}

			}else if(sort.equals("d")){  //최신순 정렬일때

				if(msort.indexOf("d:1:1") != -1){
					msort = msort.replace("d:1:1", "d:1:0");
				}else if(msort.indexOf("d:1:0") != -1){
					msort = msort.replace("d:1:0", "");
				}else{
					msort = "d:1:1";  //최신순 내림차순으로 추가
				}

			}else if(sort.equals("s")){  //저자순 정렬일때

				if(msort.indexOf("s:3:0") != -1){
					msort = msort.replace("s:3:0", "s:3:1");
				}else if(msort.indexOf("s:3:1") != -1){
					msort = msort.replace("s:3:1", "");
				}else{
					msort = "s:3:0";  //저자순 오름차순으로 추가
				}

			}

			//System.out.println("msort===========>"+msort);


			//통합검색 URL
			totalUrl = baseUrl+"?w=total&q="+URLEncoder.encode(query,"UTF-8")+"&pg="+page+"&p1="+p1+"&d1="+d1+"&outmax="+outmax+"&base64=Y&csq="+csq+"&msort="+msort;

			///////////////////////////////////문헌DB_년도_저자(왼쪽 리스트)////////////////////////////
			FrontSearchVO pubVo = null;
			FrontSearchVO isuVo = null;
			FrontSearchVO authorVo = null;

			List<FrontSearchVO> pubList = new ArrayList<FrontSearchVO>();
			List<FrontSearchVO> isuList = new ArrayList<FrontSearchVO>();
			List<FrontSearchVO> authorList = new ArrayList<FrontSearchVO>();

			int pubCnt = 0;
			int isuCnt = 0;
			int authorCnt = 0;

//			System.out.println(leftUrl);

			document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(leftUrl);
		    doc = document.getDocumentElement();

			secList = doc.getChildNodes();

			//System.out.println("secList size===>"+secList.getLength());

			for (int i = 0; i < secList.getLength(); i++) {

				if(secList.item(i).getNodeName().equals("section_group")){

					//System.out.println("secList name ===>"+secList.item(i).getNodeName());

					//어떤 섹션인지 알기 위해 선언
					NamedNodeMap secMap = secList.item(i).getAttributes();


					//System.out.println("1.name =====> "+secMap.item(0).getNodeName());
					//System.out.println("2.name =====> "+secMap.item(1).getNodeName());
					//System.out.println("3.value =====> "+secMap.item(1).getTextContent().trim());

					if(secMap.item(1).getTextContent().trim().equals("1")){  // 문헌DB+

						NodeList secChildList = secList.item(i).getChildNodes();

						for (int j = 0; j < secChildList.getLength(); j++) {
							pubVo = new FrontSearchVO();
							NamedNodeMap docMap = secChildList.item(j).getAttributes();

							if(secChildList.item(j).getNodeName().equals("reg_group")){  // 문헌DB+

								pubCnt += Integer.parseInt(docMap.item(0).getTextContent()); //총개수

								//System.out.println("pubCnt====>"+pubCnt);

								//System.out.println("doc name==>"+secChildList.item(j).getNodeName());

								//System.out.println("doc id value====>"+docMap.item(0).getNodeName());

								//System.out.println("doc id value====>"+docMap.item(0).getTextContent()); //count


								//System.out.println("doc id value====>"+docMap.item(1).getTextContent());
								//System.out.println("doc value==>"+secChildList.item(j).getTextContent().trim());


								//System.out.println("pub_id value===>"+Base64Decoder.decode(secChildList.item(j).getTextContent().trim()));

								String pubId = Base64Decoder.decode(secChildList.item(j).getTextContent().trim());

								pubVo.setPUB_ID(pubId);

								if(pubId.equals("924")){
									pubVo.setPUB_NAME("도시정보");
									pubVo.setCOUNT(docMap.item(0).getTextContent());

									pubList.add(pubVo);
								}else if(pubId.equals("925")){
									pubVo.setPUB_NAME("국토계획");
									pubVo.setCOUNT(docMap.item(0).getTextContent());

									pubList.add(pubVo);
								}else if(pubId.equals("1001")){
									pubVo.setPUB_NAME("학술발표논문집");
									pubVo.setCOUNT(docMap.item(0).getTextContent());

									pubList.add(pubVo);
								}else if(pubId.equals("1002")){
									pubVo.setPUB_NAME("APPR학회지");
									pubVo.setCOUNT(docMap.item(0).getTextContent());

									pubList.add(pubVo);
								}else if(pubId.equals("1003")){
									pubVo.setPUB_NAME("세미나자료집");
									pubVo.setCOUNT(docMap.item(0).getTextContent());

									pubList.add(pubVo);
								}
//								else if(pubId.equals("1731")){
//									pubVo.setPUB_NAME("대한국토·도시계획학회 단행본");
//								}


							}

						}


					}else if(secMap.item(1).getTextContent().trim().equals("2")){  //년도


						NodeList secChildList = secList.item(i).getChildNodes();

						//System.out.println("2222222222222222222222222222------>"+secChildList.getLength());

						for (int j = 0; j < secChildList.getLength(); j++) {
							isuVo = new FrontSearchVO();

							NamedNodeMap docMap = secChildList.item(j).getAttributes();

							if(secChildList.item(j).getNodeName().equals("reg_group")){  // 문헌DB+

								isuCnt += Integer.parseInt(docMap.item(0).getTextContent()); //총개수

								//System.out.println("pub_id value===>"+Base64Decoder.decode(secChildList.item(j).getTextContent().trim()));

								isuVo.setISU_YEAR(Base64Decoder.decode(secChildList.item(j).getTextContent().trim()));

								//System.out.println("value===>"+Base64Decoder.decode(secChildList.item(j).getTextContent()));
								isuVo.setCOUNT(docMap.item(0).getTextContent());

								isuList.add(isuVo);
							}

						}

					}

				}

			}


			Comparator<FrontSearchVO> countSort = new Comparator<FrontSearchVO>() {
				public int compare(FrontSearchVO o1, FrontSearchVO o2) {

					return Integer.parseInt(o1.getCOUNT()) > Integer.parseInt(o2.getCOUNT()) ? -1 : Integer.parseInt(o1.getCOUNT()) < Integer.parseInt(o2.getCOUNT()) ? 1:0;
				}
			};

			Collections.sort(pubList, countSort);


			//저자 왼쪽 목록 가져오기
//			System.out.println(leftUrl2);

			document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(leftUrl2);
		    doc = document.getDocumentElement();

			secList = doc.getChildNodes();

			//System.out.println("secList size===>"+secList.getLength());

			for (int i = 0; i < secList.getLength(); i++) {

				if(secList.item(i).getNodeName().equals("section_group")){

					//System.out.println("secList name ===>"+secList.item(i).getNodeName());

					//어떤 섹션인지 알기 위해 선언
					NamedNodeMap secMap = secList.item(i).getAttributes();


					//System.out.println("1.name =====> "+secMap.item(0).getNodeName());
					//System.out.println("2.name =====> "+secMap.item(1).getNodeName());
					//System.out.println("3.value =====> "+secMap.item(1).getTextContent().trim());

					if(secMap.item(1).getTextContent().trim().equals("3")){  // 저자

						NodeList secChildList = secList.item(i).getChildNodes();

						for (int j = 0; j < secChildList.getLength(); j++) {

							authorVo = new FrontSearchVO();
							NamedNodeMap docMap = secChildList.item(j).getAttributes();

							if(secChildList.item(j).getNodeName().equals("reg_group")){  // 문헌DB+

								authorCnt += Integer.parseInt(docMap.item(0).getTextContent()); //총개수

								//System.out.println("doc name==>"+secChildList.item(j).getNodeName());

								//System.out.println("doc id value====>"+docMap.item(0).getNodeName());

								//System.out.println("doc id value====>"+docMap.item(0).getTextContent()); //count


								//System.out.println("doc id value====>"+docMap.item(1).getTextContent());
								//System.out.println("doc value==>"+secChildList.item(j).getTextContent().trim());

								//System.out.println("value===>"+Base64Decoder.decode(secChildList.item(j).getTextContent().trim()));

								authorVo.setATCL_AUTHOR(Base64Decoder.decode(secChildList.item(j).getTextContent().trim()));

								authorVo.setCOUNT(docMap.item(0).getTextContent());

								authorList.add(authorVo);

							}

						}

					}

				}

			}


			Comparator<FrontSearchVO> countSort2 = new Comparator<FrontSearchVO>() {

				public int compare(FrontSearchVO o1, FrontSearchVO o2) {

					if (Integer.parseInt(o1.getCOUNT()) == Integer.parseInt(o2.getCOUNT())) {
						return o1.getATCL_AUTHOR().compareTo(o2.getATCL_AUTHOR());
					}

					return 0;
				}
			};

			Collections.sort(authorList, countSort2);

			///////////////////////////////////통합검색//////////////////////////////////////////////////////////////////////////////////
			FrontSearchVO totalSearchVo = null;

			List<FrontSearchVO> totalSearchList = new ArrayList<FrontSearchVO>();

//			System.out.println(totalUrl);

			document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(totalUrl);
		    doc = document.getDocumentElement();

			secList = doc.getChildNodes();

			//System.out.println("secList size===>"+secList.getLength());

			for (int i = 0; i < secList.getLength(); i++) {

				if(secList.item(i).getNodeName().equals("section")){

					//System.out.println("secList name ===>"+secList.item(i).getNodeName());

					//어떤 섹션인지 알기 위해 선언
					NamedNodeMap secMap = secList.item(i).getAttributes();

					if(secMap.item(0).getTextContent().equals("all")){

						//section cate childNode
						NodeList secChildList = secList.item(i).getChildNodes();

						//System.out.println("secChildList size===>"+secChildList.getLength());

						for (int j = 0; j < secChildList.getLength(); j++) {

							totalSearchVo = new FrontSearchVO();

							if(secChildList.item(j).getNodeName().equals("totcnt")){

								//System.out.println("totcnt ====>"+secChildList.item(j).getTextContent());

								total = Integer.parseInt(secChildList.item(j).getTextContent());

							}else if(secChildList.item(j).getNodeName().equals("maxcnt")){
								//System.out.println("maxcnt ====>"+secChildList.item(j).getTextContent());

								pageSize = Integer.parseInt(secChildList.item(j).getTextContent());
							}
//							else if(secChildList.item(j).getNodeName().equals("outcnt")){
//								//System.out.println("outcnt ====>"+secChildList.item(j).getTextContent());
//
//								pageMax = secChildList.item(j).getTextContent();
//							}else if(secChildList.item(j).getNodeName().equals("pagenum")){
//								//System.out.println("pagenum ====>"+secChildList.item(j).getTextContent());
//
//								pageIndex = secChildList.item(j).getTextContent();
//							}
							else if(secChildList.item(j).getNodeName().equals("doc")){

								//System.out.println("secChildList name ===>"+secChildList.item(j).getNodeName());

								NodeList docList = secChildList.item(j).getChildNodes();

								for (int k = 0; k < docList.getLength(); k++) {

									if(docList.item(k).getNodeName().equals("att")){

										NamedNodeMap docMap = docList.item(k).getAttributes();


										if(docMap.item(0).getTextContent().equals("pub_id")){
											//System.out.println(" 저널 ID===>"+Base64Decoder.decode(docList.item(k).getTextContent()));
											String pubId = Base64Decoder.decode(docList.item(k).getTextContent());

											totalSearchVo.setPUB_ID(pubId);

											if(pubId.equals("924")){
												totalSearchVo.setPUB_NAME("도시정보");
											}else if(pubId.equals("925")){
												totalSearchVo.setPUB_NAME("국토계획");
											}else if(pubId.equals("1001")){
												totalSearchVo.setPUB_NAME("학술발표논문집");
											}else if(pubId.equals("1002")){
												totalSearchVo.setPUB_NAME("APPR학회지");
											}else if(pubId.equals("1003")){
												totalSearchVo.setPUB_NAME("세미나자료집");
											}
//											else if(pubId.equals("1731")){
//												totalSearchVo.setPUB_NAME("대한국토·도시계획학회 단행본");
//											}

										}else if(docMap.item(0).getTextContent().equals("isu_id")){
											//System.out.println("저널 권호 ID===>"+Base64Decoder.decode(docList.item(k).getTextContent()));
											totalSearchVo.setISU_ID(Base64Decoder.decode(docList.item(k).getTextContent()));
										}else if(docMap.item(0).getTextContent().equals("atcl_id")){
											//System.out.println(" 논문 ID===>"+Base64Decoder.decode(docList.item(k).getTextContent()));
											totalSearchVo.setATCL_ID(Base64Decoder.decode(docList.item(k).getTextContent()));
										}else if(docMap.item(0).getTextContent().equals("atcl_name")){
											//System.out.println("논문 제목(주제목)===>"+Base64Decoder.decode(docList.item(k).getTextContent()));
											totalSearchVo.setATCL_NAME(Base64Decoder.decode(docList.item(k).getTextContent()));
										}else if(docMap.item(0).getTextContent().equals("atcl_name2")){
											//System.out.println(" 논문 제목(부제목)===>"+Base64Decoder.decode(docList.item(k).getTextContent()));
											totalSearchVo.setATCL_NAME2(Base64Decoder.decode(docList.item(k).getTextContent()));
										}else if(docMap.item(0).getTextContent().equals("atcl_author")){
											//System.out.println("논문 저자===>"+Base64Decoder.decode(docList.item(k).getTextContent()));
											totalSearchVo.setATCL_AUTHOR(Base64Decoder.decode(docList.item(k).getTextContent()));
										}else if(docMap.item(0).getTextContent().equals("isu_name")){
											//System.out.println("논문 수록된 저널 제목===>"+Base64Decoder.decode(docList.item(k).getTextContent()));
											totalSearchVo.setISU_NAME(Base64Decoder.decode(docList.item(k).getTextContent()));
										}else if(docMap.item(0).getTextContent().equals("isu_year")){
											//System.out.println(" 논문 수록된 저널 출간년도===>"+Base64Decoder.decode(docList.item(k).getTextContent()));
											totalSearchVo.setISU_YEAR(Base64Decoder.decode(docList.item(k).getTextContent()));
										}else if(docMap.item(0).getTextContent().equals("isu_month")){
											//System.out.println(" 논문 수록된 저널 출간 월===>"+Base64Decoder.decode(docList.item(k).getTextContent()));
											totalSearchVo.setISU_MONTH(Base64Decoder.decode(docList.item(k).getTextContent()));
										}else if(docMap.item(0).getTextContent().equals("isu_start")){
											//System.out.println(" 시작페이지===>"+Base64Decoder.decode(docList.item(k).getTextContent()));
											totalSearchVo.setISU_START(Base64Decoder.decode(docList.item(k).getTextContent()));
										}else if(docMap.item(0).getTextContent().equals("isu_total")){
											//System.out.println(" 전체페이지===>"+Base64Decoder.decode(docList.item(k).getTextContent()));
											totalSearchVo.setISU_TOTAL(Base64Decoder.decode(docList.item(k).getTextContent()));
										}else if(docMap.item(0).getTextContent().equals("jnl_issn")){
											//System.out.println(" ISSN===>"+Base64Decoder.decode(docList.item(k).getTextContent()));
											totalSearchVo.setJNL_ISSN(Base64Decoder.decode(docList.item(k).getTextContent()));
										}else if(docMap.item(0).getTextContent().equals("atcl_keyword")){
											//System.out.println(" 논문 키워드===>"+Base64Decoder.decode(docList.item(k).getTextContent()));
											totalSearchVo.setATCL_KEYWORD(Base64Decoder.decode(docList.item(k).getTextContent()));
										}else if(docMap.item(0).getTextContent().equals("atcl_abstract")){
											//System.out.println(" 논문 초록===>"+Base64Decoder.decode(docList.item(k).getTextContent()));
											totalSearchVo.setATCL_ABSTRACT(Base64Decoder.decode(docList.item(k).getTextContent()));
										}else if(docMap.item(0).getTextContent().equals("atcl_lang")){
											//System.out.println(" 논문 작성 주언어===>"+Base64Decoder.decode(docList.item(k).getTextContent()));
											totalSearchVo.setATCL_LANG(Base64Decoder.decode(docList.item(k).getTextContent()));
										}else if(docMap.item(0).getTextContent().equals("atcl_author_1st")){
											//System.out.println(" 대표저자(정렬용)===>"+Base64Decoder.decode(docList.item(k).getTextContent()));
											totalSearchVo.setATCL_AUTHOR_1ST(Base64Decoder.decode(docList.item(k).getTextContent()));
										}else if(docMap.item(0).getTextContent().equals("atcl_content")){
											//System.out.println(" 본문===>"+Base64Decoder.decode(docList.item(k).getTextContent()));
											totalSearchVo.setATCL_CONTENT(Base64Decoder.decode(docList.item(k).getTextContent()));
										}else if(docMap.item(0).getTextContent().equals("atcl_link")){
											totalSearchVo.setATCL_LINK(Base64Decoder.decode(docList.item(k).getTextContent()));
										}
									}

								}

								totalSearchList.add(totalSearchVo);

							}

						}

					}

				}

			}




			///////////////////////////////////인기검색어////////////////////////////////////////////////////////////////////////
			model.addAttribute("pubList", pubList);
			model.addAttribute("isuList", isuList);
			model.addAttribute("authorList", authorList);
			model.addAttribute("pubCnt", pubCnt);
			model.addAttribute("isuCnt", isuCnt);
			model.addAttribute("authorCnt", authorCnt);

			model.addAttribute("totalSearchList", totalSearchList);

			input.put("pageIndex", pageIndex);
			input.put("pageSize",pageSize);
			input.put("total", total);
			input.put("pageMax",  (int)Math.ceil((double)total/pageSize));
			model.addAttribute("input", input);

			//인기검색어
			model.addAttribute("statisList", getSearchTag());

			if(query.equals("*"))
				query = query.replace("*", "");
			else
				query = query.substring(1, (query.length()-1)).replace("*", " ");

			model.addAttribute("keyword", query);
			model.addAttribute("pub_id", pub_id);
			model.addAttribute("pub_temp", pub_temp);
			model.addAttribute("yearMonth", yearMonth);
			model.addAttribute("ym_temp", ym_temp);
			model.addAttribute("author", author);
//			model.addAttribute("sort", sort);
			model.addAttribute("msort", msort);
			model.addAttribute("searchType", searchType);
			model.addAttribute("csq", csq_temp);
			model.addAttribute("showSize", outmax);

			model.addAttribute("dSubject", dSubject);
			model.addAttribute("dAuthor", dAuthor);
			model.addAttribute("dKeyword", dKeyword);


		}catch(Exception e){
			log.error(e.getMessage());
			e.printStackTrace();
		}

		return "/zcms/frontsys/search/front/list";

	}


	@RequestMapping(value = "/getSearchTag.html")
	public String getSearchTag(Model model,HttpServletRequest request,HttpSession session) {

		try {

			model.addAttribute("frontStatisList", getSearchTag());

		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
			e.printStackTrace();
		}


		return "/zcms/frontsys/search/front/getSearchTag";
	}

	@RequestMapping(value="/excel.html")
	public String excel(Model model,@RequestParam String keyword, @RequestParam String excel_val) throws Exception
	{

		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyyMMdd", Locale.KOREA );
		Date currentTime = new Date ( );
		String mTime = mSimpleDateFormat.format ( currentTime );

		String fileName = keyword+"_"+mTime;

		model.addAttribute("file_name", fileName);
		model.addAttribute("excel_val", excel_val);

		return "/zcms/frontsys/search/front/excel";
	}



	//인기 검색어 가져오기
	public static List<FrontSearchVO> getSearchTag() throws Exception{
		///////////////////////////////////인기검색어////////////////////////////////////////////////////////////////////////
		FrontSearchVO statisVo = null;

		List<FrontSearchVO> statisList = new ArrayList<FrontSearchVO>();

		Calendar cal = new GregorianCalendar();
	    cal.add(Calendar.DATE, -1);

	    //System.out.println("어제 월: " + (cal.get(Calendar.MONTH) + 1));
	    //System.out.println("어제 일: " +  cal.get(Calendar.DAY_OF_MONTH));

	    String month = Integer.toString(cal.get(Calendar.MONTH) + 1);
	    String day = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));

	    if(month.length() == 1){
	    	month = "0"+month;
	    }

	    if(day.length() == 1){
	    	day = "0"+day;
	    }

//		String baseUrl = "http://115.71.232.2:7578/srch_statisxml";
	    String baseUrl = EgovProperties.getProperty("Globals.searchRecent.url");
		String date = month+day; //주기에따른 보고자 하는 시점 ( 하루전날짜 입력)
		String hl_date = ""; //

		String statisUrl = baseUrl+"?w=sr_tot&cycle=w&date="+date+"&hl_date="+hl_date+"&base64=Y";

		//System.out.println(statisUrl);

		document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(statisUrl);
		doc = document.getDocumentElement();

		secList = doc.getChildNodes();

		//System.out.println("secList size===>"+secList.getLength());

		for (int i = 0; i < secList.getLength(); i++) {

			if(secList.item(i).getNodeName().equals("statis")){

			//System.out.println("secList name ===>"+secList.item(i).getNodeName());

			//어떤 섹션인지 알기 위해 선언
			NamedNodeMap secMap = secList.item(i).getAttributes();

				if(secMap.item(0).getTextContent().equals("sr_tot")){

					//section cate childNode
					NodeList secChildList = secList.item(i).getChildNodes();

					//System.out.println("secChildList size===>"+secChildList.getLength());

					for (int j = 0; j < secChildList.getLength(); j++) {

						statisVo = new FrontSearchVO();

						if(secChildList.item(j).getNodeName().equals("ranking")){

							//System.out.println("secChildList name ===>"+secChildList.item(j).getNodeName());

							NodeList docList = secChildList.item(j).getChildNodes();

							for (int k = 0; k < docList.getLength(); k++) {

								if(docList.item(k).getNodeName().equals("att")){

									NamedNodeMap docMap = docList.item(k).getAttributes();

				//					//System.out.println("doc name==>"+docList.item(k).getNodeName());
				//					//System.out.println("doc id value====>"+docMap.item(0).getTextContent());
				//					//System.out.println("doc value==>"+docList.item(k).getTextContent());

									if(docMap.item(0).getTextContent().equals("keyword")){
										//System.out.println("keyword value===>"+Base64Decoder.decode(docList.item(k).getTextContent()));

										statisVo.setSTATIS(Base64Decoder.decode(docList.item(k).getTextContent()));

									}
								}

							}

							statisList.add(statisVo);
						}
					}
				}
			}
		}

		return statisList;

	}*/


}
