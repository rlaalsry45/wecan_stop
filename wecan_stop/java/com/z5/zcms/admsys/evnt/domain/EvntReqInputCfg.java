package com.z5.zcms.admsys.evnt.domain;

import com.z5.zcms.admsys.common.domain.CommonVo;

public class EvntReqInputCfg  extends CommonVo{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9096199649939826313L;

		private String req_no; 
		private String contact_yn; 
		private String addr_yn; 
		private String evnt_no; 
		private String additional_yn; 
		private String additional_conts; 
		private String attach_yn;
		private String extra_yn;
		
		public String getExtra_yn() {
			return extra_yn;
		}
		public void setExtra_yn(String extra_yn) {
			this.extra_yn = extra_yn;
		}
		public String getReq_no() {
			return req_no;
		}
		public void setReq_no(String req_no) {
			this.req_no = req_no;
		}
		public String getContact_yn() {
			return contact_yn;
		}
		public void setContact_yn(String contact_yn) {
			this.contact_yn = contact_yn;
		}
		public String getAddr_yn() {
			return addr_yn;
		}
		public void setAddr_yn(String addr_yn) {
			this.addr_yn = addr_yn;
		}
		public String getEvnt_no() {
			return evnt_no;
		}
		public void setEvnt_no(String evnt_no) {
			this.evnt_no = evnt_no;
		}
		public String getAdditional_yn() {
			return additional_yn;
		}
		public void setAdditional_yn(String additional_yn) {
			this.additional_yn = additional_yn;
		}
		public String getAdditional_conts() {
			return additional_conts;
		}
		public void setAdditional_conts(String additional_conts) {
			this.additional_conts = additional_conts;
		}

		public String getAttach_yn() {
			return attach_yn;
		}
		public void setAttach_yn(String attach_yn) {
			this.attach_yn = attach_yn;
		}
		
	
}

