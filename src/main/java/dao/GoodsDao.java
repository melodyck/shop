package dao;

import entity.Goods;

import java.util.List;

public interface GoodsDao {

    int findCount(int gid);

    List<Goods> findByPage(int gid, int start, int pageSize);

    Goods findById(int gid);
}
