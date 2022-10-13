
// 체크박스 전체선택 
$(document).ready(function() {
			$("#checkall").click(function() {
				if($("#checkall").is(":checked")) $("input[name=cartChkBox]").prop("checked", true);
				else $("input[name=cartChkBox]").prop("checked", false);
			});
// 전체체크 갯수와 체크된 체크박스의 갯수가 다르면 전체선택 해제 
			$("input[name=cartChkBox]").click(function() {
				let total = $("input[name=cartChkBox]").length;
				let checked = $("input[name=cartChkBox]:checked").length;
				
				if(total != checked) $("#checkall").prop("checked", false);
				else $("#checkall").prop("checked", true); 
			});
		
		
// 수량버튼 증감
	let quantity = $(".quantity_input").val();
	$(".plus_btn").on("click", function(){
		$(".quantity_input").val(++quantity);
	});
	$(".minus_btn").on("click", function(){
		if(quantity > 1){
			$(".quantity_input").val(--quantity);	
		}
	});	
});



// 서버로 전송할 데이터(장바구니 추가)
	const form = {
		bId : '${buyer.bId}',
		pCode : '${goodsInfo.pCode}',
		pdtCartAmo : ''
}

/* 장바구니 추가버튼 ->상세페이지에 버튼 필요 
	$(".btn_cart").on("click", function(e){
		form.bookCount = $(".quantity_input").val();
		$.ajax({
			url: '/cart/add',			//호출할  url
			type: 'POST',				//호출할 방법
			data: form,					//서버로 보낼 데이터
			success: function(result){	//성공시 수행될 메소드,파라미터는 서버가 반환한 값
			}
		})
	});
	
*/
	

	function cart(){
		$.ajax({
			url: '/product/pcart',				//호출할  url
			type: 'get',						//호출할 방법
			data: {"bId":"spring"},				//서버로 보낼 데이터
			success: function(result){  		//성공시 수행될 메소드,파라미터는 서버가 반환한 값
				alert(result);	
				document.getElementById("cart").innerHTML = result;
			}
		})
	}