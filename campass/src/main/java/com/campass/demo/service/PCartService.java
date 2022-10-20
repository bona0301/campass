package com.campass.demo.service;

public class PCartService {
	@Autowired
	PdtCartDao cartDao;
	
	// 장바구니 추가
		public String pAddCart(PdtCartDto.pAddCart dto) {
			
			// 장바구니에 동일한상품이 있다면 새로추가 하는 게 아니라 수량을 변경한다 
			if(cartDao.checkCart(dto.getPCode(), dto.getBId())) {
				
				cartDao.cartPlus(dto.getPCode(), dto.getPdtCartAmo(), dto.getBId());
				
				return "기존 장바구니 상품의 수량이 변경되었습니다";
			}
			
				PdtCart pdtcart = dto.toEntity();
				cartDao.pAddCart(pdtcart);
				return "장바구니에 상품을 추가했습니다";
	}
		
		
	// 장바구니 정보 리스트 
		public List<PdtCartDto.Read> listCart(String bId) {
			
			List<Read> cart = cartDao.listCart(bId);
			
//			for(Read dto : cart) {
//				dto.initTotalPrice();
//			}
			return cart;
		}
		
	// 장바구니 삭제
		public void cartDelete(PdtCartDto.delete list) {
			for(int i = 0; i<list.getPdtCartNo().size(); i++) {
				//cartDao.cartDelete(a.).get());
				cartDao.cartDelete(list.getPdtCartNo().get(i));
			}
		}
	
	// 수량변경 
		public List<PdtCartDto.Read> UpdateCount(PdtCartDto.cartCountUpdate dto) {
			
			if(dto.getCountVal()) { // true 일 경우 + false 일 경우 -
				cartDao.cartAmoPlusCount(dto.getPdtCartNo());
				return cartDao.listCart(dto.getBId());
			}
			else {
				// 1아래로 감소 불가
				if(cartDao.getCount(dto.getPdtCartNo()).get()>1) {
					cartDao.cartAmoMinusCount(dto.getPdtCartNo());
					return cartDao.listCart(dto.getBId());
				}
				return cartDao.listCart(dto.getBId());
			}	
		}
		
}
