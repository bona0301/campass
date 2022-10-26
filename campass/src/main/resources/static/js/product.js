	$(document).ready(async function(){
		/* 페이징 */
		const apiUrl = '/product/list';
		const pageno = getPageno();
		const params = {pageno : pageno, pCode : 1};
		const response = await $.ajax({url: apiUrl, data: params}).done((response)=>{
		}).fail((error)=>{
			console.log(error);
		});
		
		let array = [{response}]
		
		console.log(response.productList)
		for(const list of response.productList){
			const b = $("<tr>").attr("value",list.pcode).attr("class","product").appendTo("#list")
						
			const i = $("<td>").appendTo(b);
			$("<img>").attr("src", list.pmainImg).attr("class","pmainImgClass").appendTo(i);
			$("<td>").text("상품명 : "+list.pname).appendTo(i);
			$("<td>").text("가격 : "+list.pprice.toLocaleString()+"원").attr("class","pprice").appendTo(i);
		
			
		} 
		
		$(document).on("click", ".product", function(){
			location.href ="/product/product_detail?pcode=" + $(this).attr("value")
		})
		
		console.log(response.pageno);
		const paging = {pageno : response.pageno, pagesize : response.pagesize, totalcount : response.totalcount}
		const pagination = getPagination(paging);

		printPagination(pagination);
		
		
		
	})
	
	//페이징
		function getPageno() {
			const pageno = location.search.substring(8)

			if(pageno==null)
				return 1;
			if(isNaN(pageno))
				return 1;
			if(pageno<1)
				return 1;
			return pageno;
		}
	
	// prev, start, end, next 계산
		function getPagination({pageno, pagesize, totalcount, blocksize = 4}) {
			const countOfPage = Math.ceil(totalcount / pagesize);
			const prev = Math.floor((pageno - 1) / blocksize) * blocksize;
			const start = prev + 1;
			let end = prev + blocksize;
			let next = end + 1;
			if (end >= countOfPage) {
				end = countOfPage;
				next = 0;
			}
			return {pageno, prev, start, end, next};
		}

		// pagination 출력
		function printPagination({pageno, prev, start, end, next}) {
			console.log("=============")
			console.log(prev);
			console.log(start);
			const pagination_li = $('.pagination li');
			for (let i = start; i <= end; i++) {
				const $li = $(pagination_li[i]);
				$li.css('display', 'block').children('a').attr("href", "/product?pageno=" + i).text(i);
				if (i === pageno)
					$li.addClass('active');
			}
		}