package dao;

import entity.goods;

import java.util.List;

public interface GoodsDao {
    int findCount(int gid);

    List<goods> findByPage(int gid, int start, int pageSize);

    goods findById(int gid);
}
