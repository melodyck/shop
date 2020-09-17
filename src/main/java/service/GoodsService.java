package service;

import entity.PageBean;
import entity.Goods;

public interface GoodsService {
    PageBean<Goods> searchByPage(String str, int currentPage, int pageSize);

    PageBean<Goods> findByPage(int lid, int currentPage, int pageSize);

    Goods findOne(int gid);

}
