
$(document).ready(async function() {

	let result = await getList()
	
	printCartList(result);
	setTotalInfo()

// 체크박스 전체선택, 금액계산 
	$(document).on("click", '.cboxall' , function() {
		if ($('.cboxall').is(":checked")) {
			$('.cbox').prop("checked", true);
			setTotalInfo($(".cart_info"))
		} else {
			$('.cbox').prop("checked", false);
			setTotalInfo($(".cart_info"))
		}
	});
	
// 체크박스 선택시 금액 변경 
	$(document).on("change",  ".cbox", function() {
		setTotalInfo($(".cart_info"))
	});
	
// 장바구니 리스트 출력 
	async function getList() {
		return await $.ajax({
			url: '/pcart/list',			//호출할  url
			data: { bId: "spring" }		//서버로 보낼 데이터
		});
	}

// 체크박스 일부선택시 전체선택 해제 
	$(document).on("click", ".cbox", function() {
		let total = $(".cbox").length;
		let checked = $(".cbox:checked").length;

		if (total == checked) {
			$(".cboxall").prop("checked", true);
		}
		else {
			$(".cboxall").prop("checked", false)
		}
	});
	
// 장바구니 리스트 출력 
	function printCartList(result) {
	
		for (const list of result) {
			//const b = $("<tr>").appendTo("#cart")
			const b = $("<tr>").attr("value", list.pdtCartNo).attr("class", "cart_info").appendTo("#cart")
			//자식.appendTo(부모)    자식
			//부모.append(자식)		부모
			//$("<td>").append('<input type="checkbox" class="cbox" data-mno=1 checked="checked">').appendTo(b);
			$("<td>").append(`<input type="checkbox" class="cbox" data-mno = ${list.pdtCartNo} checked="checked">`).appendTo(b);
			$("<td>").text("사진").appendTo(b);
			$("<td>").text(list.pname).appendTo(b);
			$("<td>").text(list.pbrand).appendTo(b);
			const $ptd = $("<td>").text(list.pprice).attr("class", "pprice_input").attr("value", list.pprice).appendTo(b);
			$("<input>").attr("type", "hidden").attr("class", "totalPrice").attr("value", list.pprice * list.pdtCartAmo).appendTo($ptd);
	
			// 수량수정버튼
			const $td = $("<td>").attr("class", "pdtCartAmo_input").attr("value", list.pdtCartAmo).appendTo(b);
			$("<button>").text("-").attr("value", list.pdtCartNo).attr("value2", false).attr("class", "countbutton").appendTo($td);
			$("<span>").text(list.pdtCartAmo).appendTo($td)
			$("<button>").text("+").attr("value", list.pdtCartNo).attr("value2", true).attr("class", "countbutton").appendTo($td);
			
			$("<span>").append(`<input type="hidden" class="pCode_input" value = ${list.pcode}>`).appendTo($td);
	};

	checkBoxReset()
}

// 결제금액 계산
	function setTotalInfo() {

		let totalPrice = 0;
		let deliveryPrice = 0;			// 배송비
		let finalTotalPrice = 0; 		// 최종 가격(총 가격 + 배송비)
	
	//체크박스 선택값 금액 계산  
		$(".cart_info").each(function(index, element) {
	
			if ($(element).find(".cbox").is(":checked") === true) {
				// 총 가격
				totalPrice += parseInt($(element).find(".totalPrice").attr("value"));
			}
		});
	
		/* 배송비 결정 */
		if (totalPrice >= 70000) {
			deliveryPrice = 0;
		} else if (totalPrice == 0) {
			deliveryPrice = 0;
		} else {
			deliveryPrice = 3000;
		}
		finalTotalPrice = totalPrice + deliveryPrice;
	
		/* ※ 세자리 컴마 Javscript Number 객체의 toLocaleString() */
	
		// 총 가격
		$(".totalPrice").text(totalPrice.toLocaleString());
		// 배송비
		$(".delivery_price").text(deliveryPrice);
		// 최종 가격(총 가격 + 배송비)
		$(".finalTotalPrice").text(finalTotalPrice.toLocaleString());
}


// 수량변경시 체크박스 리셋
	function checkBoxReset() {
		let arr = new Array();
		$('.cbox').each(function(index) {
			arr[index] = $('.cbox').prop("checked")
		})
		const set = new Set(arr)

		if (set.size == 1) {
			$('.cboxall').prop("checked", true);
		}
	}


// 수량변경 
	$(document).on("click", ".countbutton", function() {
		const params = {
			pdtCartNo: $(this).attr("value"),
			countVal: $(this).attr("value2"),
			bId: "spring"
		};
		$.ajax({
			url: "/pcart/countupdate",
			data: params,
			method: "put"
		}).done((response) => { $(".cart_info").remove(); printCartList(response.result); setTotalInfo(); alert(response.message);})
		  .fail((response) => { alert(response.message); })
	})
	
// 체크박스 선택삭제
	$("#delete").click(function() {
		// 선택한 메뉴 번호들을 담을 배열
		const arr = [];
		
		// 반복문을 돌리면서 사용자가 선택한 메뉴 번호들을 배열에 하나씩 담는다
		$(".cbox").each(function(idx, element) {
			const $element = $(element);
			if($element.prop("checked")==true) {
				arr.push($element.attr("data-mno"));
			}	
		});
		console.log(arr);

		// list란 이름으로 서버로 보낸다. 서버에서도 list란 이름의 DTO로 받는다
		const params = {
			pdtCartNo : arr, 
			username : "spring"
		}
		$.ajax({
			url: "/pcart/delete",
			method: "delete",
			data: params
		}).done((response) => {alert(response.message); location.href = location.href;})
		  .fail((response) => {alert(response.message); location.href = location.href;})
	})

// 구매하기 버튼 	
$(".order_btn").on("click", function(){
	let form_contents ='';
	let orderNumber = 0;
	
	//선택된 체크박스에서 금액,갯수 배열로 잡기 
		const arr = [];
			$(".cbox").each(function(index, element){
				const $element = $(element);
					if($element.prop("checked")==true) {
						let pPrice = parseInt(($(this).parent().next().next().next().text()));
						let pdtCartAmo = parseInt(($(this).parent().next().next().next().next().next().text()));
					}
			});
			
			$.ajax({
				url: "/test_result4_order",
				method: "post",
				data: "list[0].mno=1&list[0].count=2&list[1].mno=3&list[1].count=11"
				}).done(response=>console.log(response))
				  .fail(response=>console.log(response))
});
			
			
			
})
