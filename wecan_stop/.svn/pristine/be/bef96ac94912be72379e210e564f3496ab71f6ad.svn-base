//팝업존
var visualWhich = 2;
var visualTimer;
var vtotalSize = 0;
var visualPt = 0;
var VisualNt = 0;

function forwardVisual()
{
	for (var i=1;i<=vtotalSize;i++) 
	{
		var fldbtn = document.getElementById("vbtn"+(i));
		fldbtn.src = (i == visualWhich) ? '/usr/images/new_main/pop_on.png' : '/usr/images/new_main/pop_off.png';	
		var fld = document.getElementById("vnum"+(i));
		fld.className =  "visual_con" + i +" " + ((visualWhich == i ) ? '' : 'dipy_n');
	}			
	visualWhich++;			
	if (visualWhich > vtotalSize) visualWhich = 1;
	visualPt = 0;
	VisualNt = 0;
}

function forwardVisualDirect(no)
{
	StopVisual2();
	for (var i=1;i<=vtotalSize;i++) {
		var fldbtn = document.getElementById("vbtn"+(i));
		fldbtn.src = (i == no) ? '/usr/images/new_main/pop_on.png' : '/usr/images/new_main/pop_off.png';
		
		var fld = document.getElementById("vnum"+(i));
		fld.className =  "visual_con" + i +" " + ((no == i ) ? '' : 'dipy_n');
	}
	visualWhich = no+1;
	if (visualWhich > vtotalSize) visualWhich = 1;
	visualPt = 0;
	VisualNt = 0;
}

function PreviousVisual()
{
	if(visualPt < 1){
			nnum = visualWhich-2;
	}else{
		nnum = visualWhich;
	}
	if(nnum<=0){nnum = vtotalSize};
	if(nnum>vtotalSize){nnum = vtotalSize};
	for (var i=1;i<=vtotalSize;i++) {
		var fldbtn = document.getElementById("vbtn"+(i));
		fldbtn.src = (i == nnum) ? '/usr/images/new_main/pop_on.png' : '/usr/images/new_main/pop_off.png';
		
		var fld = document.getElementById("vnum"+(i));
		fld.className =  "visual_con" + i +" " + ((nnum == i ) ? '' : 'dipy_n');
	}
	visualWhich = nnum-1;
	if (visualWhich > vtotalSize) visualWhich = vtotalSize;
	visualPt = 1;
	VisualNt = 0;
}

function NextVisual()
{
	if(VisualNt < 1){
		nnum = visualWhich+2;
	}else{
		nnum = visualWhich;
	}
	if(nnum>vtotalSize){nnum = 1};
	if(nnum<=0){nnum = 1};
	for (var i=1;i<=vtotalSize;i++) {
		var fldbtn = document.getElementById("vbtn"+(i));
		fldbtn.src = (i == nnum) ? '/usr/images/new_main/pop_on.png' : '/usr/images/new_main/pop_off.png';
		
		var fld = document.getElementById("vnum"+(i));
		fld.className =  "visual_con" + i +" " + ((nnum == i ) ? '' : 'dipy_n');
	}
	visualWhich = nnum+1;
	if (visualWhich > vtotalSize) visualWhich = 1;
	visualPt = 0;
	VisualNt = 1;
}

function StopVisual() 
{
	visualPt=0;
	VisualNt=0;
	clearInterval(visualTimer);
	document.getElementById("ppause").style.display="none";
	document.getElementById("pplay").style.display="";

}
function StopVisual2() 
{
	visualPt=0;
	VisualNt=0;
	clearInterval(visualTimer);
}
function StartVisual() {
	visualPt=0;
	VisualNt=0;
	visualTimer = setInterval('forwardVisual()',5000);
	document.getElementById("ppause").style.display="";
	document.getElementById("pplay").style.display="none";
}