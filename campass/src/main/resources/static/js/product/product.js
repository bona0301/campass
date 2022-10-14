$(document).ready(async function(){
	const a = await $.ajax({
		url:'/product',		// 호출 url
		data:{pCode}		// 서버로 보낼 데이터
	})
	console.log(a);
})