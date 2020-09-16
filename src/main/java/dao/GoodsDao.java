package dao;

import entity.Goods;

import java.util.List;


public interface GoodsDao {
    Goods SearchGoods(String str);

    Goods findAllGoods();

    int findCount(int lid);

    List<Goods> findByPage(int lid, int start, int pageSize);

    Goods findById(int gid);
}
