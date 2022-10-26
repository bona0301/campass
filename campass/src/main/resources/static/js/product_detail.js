$(document).ready(async function(){
		const pCode = getpCode();
		const product = await $.ajax({
			url:"/product/detail",
			data:{pCode}
		});
		
		printProduct(product);
		printDetail(product);

        // 장바구니
        $(document).on("click", ".cart", function(){
			location.href ="/product/pcart" + $(this).attr("value")
		})
		
		// 구매하기
        $(document).on("click", ".buying", function(){
			location.href ="/product/porder" + $(this).attr("value")
		})

	})
	
	// 상세정보 가져오기
	function getpCode() {
		const pCode = location.search.substring(7);
		if(isNaN(pCode)) {
			alert("상품을 찾을 수 없습니다");
			location.href = "/";
		}
		return pCode;
	}
	
 	function printProduct(product){
		const img = $("<div>").attr("value",product.pmainImg).attr("class","product").appendTo("#img");
		$("<img>").attr("src", product.pmainImg).attr("class","pmainImgClass2").appendTo(img);
		
		$("<li>").text("브랜드 : "+product.pbrand).appendTo("#detail");
		$("<li>").text("상품명 : "+product.pname).appendTo("#detail");
		$("<li>").text("가격 : "+product.pprice.toLocaleString()+"원").appendTo("#detail");
		$("<li>").text("평점 : "+product.pstarAvg).appendTo("#detail");
	} 
	
	function printDetail(content){
		console.log(content);
		const contentImg = $("<div>").attr("value",content.pcontentImg).attr("class","contentImg").appendTo("#content")
		$("<img>").attr("src", content.pcontentImg).attr("class","pContentImgClass2").appendTo(contentImg);
	}
	
	// 리뷰리스트 가져오기
	function printReview (reviewList) {
		const $list = $('#reviewList');
		const $t = $('#tr_template').html();
		for (const r of reviewList) {
			$list.append($t.replace('{previewNo}',r.previewNo).replace('{pstar}',r.pstar).replace('{previewContent}',r.previewContent)
				.replace('{username}',r.username).replace('{previewDate}',r.previewDate));
		}
	}