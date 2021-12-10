package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.ProductDAO;
import vo.ProductVO;

public class ProductServiceImpl implements ProductService {
	
	ProductDAO product_dao_in; // 입고 dao
	ProductDAO product_dao_out; // 출고 dao
	ProductDAO product_dao_remain; // 재고 dao
	
	// setter 인젝션을 위한 준비
	public void setProduct_dao_in(ProductDAO product_dao_in) {
		this.product_dao_in = product_dao_in;
	}

	public void setProduct_dao_out(ProductDAO product_dao_out) {
		this.product_dao_out = product_dao_out;
	}

	public void setProduct_dao_remain(ProductDAO product_dao_remain) {
		this.product_dao_remain = product_dao_remain;
	}

	@Override
	public Map selectList() {
		
		Map map = new HashMap();
		
		List<ProductVO> in_list = product_dao_in.list();
		List<ProductVO> out_list = product_dao_out.list();
		List<ProductVO> remain_list = product_dao_remain.list();
		
		map.put("in_list", in_list);
		map.put("out_list", out_list);
		map.put("remain_list", remain_list);
		
		return map;
	}

	@Override
	public int insert_in(ProductVO vo) throws Exception {
		int res = 0;
		
		res = product_dao_in.insert(vo);
		
		ProductVO remain_vo = product_dao_remain.selectOne(vo.getName());
		
		if(remain_vo == null) {
			product_dao_remain.insert(vo);
 		} else {
 			int cnt = remain_vo.getCnt() + vo.getCnt();
 			remain_vo.setCnt(cnt);
 			product_dao_remain.update(remain_vo);
 		}
		return res;
	}

	@Override
	public int insert_out(ProductVO vo) throws Exception {
		int res = 0;
		
		// 출고 처리
		res = product_dao_out.insert(vo);
		
		
		// 현재 출고상품 정보가 재고에 있는지 얻어온다.
		ProductVO remain_vo = product_dao_remain.selectOne(vo.getName());
		if(remain_vo == null) { // 출고할 상품이 없는 경우
			// context-6-transaction에서 rollback-for="Exception"을 통해
			// Exception이 발생하면 product_dao_insert(vo)를 취소하고
			// 강제로 롤백한다.
			throw new Exception("등록된 상품이 없습니다(remain_not)");
		}
		
		if(vo.getCnt() > remain_vo.getCnt()) {
			throw new Exception("재고가 부족합니다(remain_lack)");
		}
		
		int cnt = remain_vo.getCnt() - vo.getCnt();
		remain_vo.setCnt(cnt);
		res = product_dao_remain.update(remain_vo);
		
		return res;
	} // insert_out()

}
