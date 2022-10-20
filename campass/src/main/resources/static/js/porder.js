

// 주문내역 리스트 출력 
	async function getList() {
		return await $.ajax({
			url: '/order/list',			//호출할  url
			data: { bId: "spring" }		//서버로 보낼 데이터
		});
	}