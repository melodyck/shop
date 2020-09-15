package service.impl;

import dao.GoodsDao;
import dao.impl.GoodsDaoImpl;
import entity.PageBean;
import entity.goods;
import service.GoodsService;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    GoodsDao goodsDao=new GoodsDaoImpl();
    @Override
    public PageBean<goods> findByPage(int gid, int currentPage, int pageSize) {
        PageBean<goods> pageBean=new PageBean<>();
        int totalCount=goodsDao.findCount(gid);
        int start =(currentPage-1)*pageSize;
        List<goods> byPage = goodsDao.findByPage(gid, start, pageSize);
        int totalPage = (totalCount + pageSize - 1) / pageSize;
        pageBean.setCurrentPage(currentPage);
        pageBean.setList(byPage);
        pageBean.setTotalCount(totalCount);
        pageBean.setPageSize(pageSize);
        pageBean.setTotalPage(totalPage);
        return pageBean;
    }

    @Override
    public goods findOne(int gid) {
        return null;
    }
}
