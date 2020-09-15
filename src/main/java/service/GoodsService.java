package service;

import entity.PageBean;
import entity.goods;

public interface GoodsService {
    PageBean<goods> findByPage(int gid,int currentPage,int pageSize);
    goods findOne(int gid);
}
