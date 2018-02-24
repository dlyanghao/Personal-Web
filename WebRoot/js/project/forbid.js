/**
 * 防止通过URL直接访问
 */
$(function(){
	if(document.referrer===''){
		$.post("error");
		document.open();
		document.write("不能通过URL地址直接访问");
		document.close();
	}
});