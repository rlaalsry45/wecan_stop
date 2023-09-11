package com.z5.zcms.admsys.evnt.domain;
import com.z5.zcms.admsys.common.domain.CommonVo;

public class EvntReqNotCfg extends CommonVo{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3830584702327777542L;
	
		private String not_cfg_no; 
		private String not_date; 
		private String reg_date; 
		private String evnt_no;
		private String part_no;
		private String not_applicant_limit;
		
		
		
		
		public String getNot_applicant_limit() {
			return not_applicant_limit;
		}
		public void setNot_applicant_limit(String not_applicant_limit) {
			this.not_applicant_limit = not_applicant_limit;
		}
		public String getPart_no() {
			return part_no;
		}
		public void setPart_no(String part_no) {
			this.part_no = part_no;
		}
		public String getNot_cfg_no() {
			return not_cfg_no;
		}
		public void setNot_cfg_no(String not_cfg_no) {
			this.not_cfg_no = not_cfg_no;
		}
		public String getNot_date() {
			return not_date;
		}
		public void setNot_date(String not_date) {
			this.not_date = not_date;
		}
		public String getReg_date() {
			return reg_date;
		}
		public void setReg_date(String reg_date) {
			this.reg_date = reg_date;
		}
		public String getEvnt_no() {
			return evnt_no;
		}
		public void setEvnt_no(String evnt_no) {
			this.evnt_no = evnt_no;
		}
		
		
	
}

