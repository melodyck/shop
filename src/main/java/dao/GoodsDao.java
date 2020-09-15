package dao;

import entity.Goods;

public interface GoodsDao {
    Goods SearchGoods(String str);

    Goods findAllGoods();


}
