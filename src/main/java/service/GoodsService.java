package service;

import entity.PageBean;
import entity.Goods;

public interface GoodsService {
    PageBean<Goods> findByPage(int gid,int currentPage,int pageSize);
    Goods findOne(int gid);
}
