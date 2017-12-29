package com.et.utils;

import java.util.List;

/**
 * ʵ����
 * ��ҳ����
 * @author Administrator
 *
 */
public class PageTools {
	/**
	 * �������
	 * @param curPage ҳ�洫��ĵ�ǰҳ
	 * @param totalCount ���ݿ��ѯ��������
	 * @param pageCount ÿҳ��ʾ������
	 */
	public PageTools(Integer curPage,Integer totalCount,Integer pageCount){
		this.curPage=curPage;
		this.pageCount=pageCount==null?this.pageCount:pageCount;
		this.total=totalCount;
		//��һҳ
		this.prePage=(curPage==1?1:curPage-1);
		//��ҳ��
		this.totalPage=totalCount%this.pageCount==0?totalCount/this.pageCount:totalCount/this.pageCount+1;
		//��һҳ
		this.nextPage=(curPage==totalPage)?totalPage:(curPage+1);
		this.startIndex=(curPage-1)*this.pageCount+1;
		this.endIndex=curPage*this.pageCount;
		
	}
	public Integer getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public Integer getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(Integer endIndex) {
		this.endIndex = endIndex;
	}
	/**
	 * ��ʼλ��
	 * curPage pageCount(ÿҳ��ʾ������)    start-end
	 * 	1			10					1-10
	 * 							
	 *  								start=(curPage-1)*pageCount+1 
	 *  								end= curPage*pageCount
	 */
	private Integer startIndex;
	/**
	 * ����λ��
	 */
	private Integer endIndex;
	/**
	 * ��ǰҳ����̬��ҳ�洫�ݵģ�
	 */
	private Integer curPage;
	/**
	 * ÿҳ��ʾ������ ��Ĭ��10����
	 */
	private Integer pageCount=10;
	/**
	 * ��һҳ
	 * prePage=(curPage==1?1:curPage-1)
	 * 
	 * ����
	 * �ڶ�ҳ    ��һҳ 1
	 * 3       ��һҳ 2
	 */
	private Integer prePage;
	/**
	 * ��һҳ
	 *
	 * nextPage=(curPage==totalpage)?totalpage:(curPage+1)
	 * ����
	 * ��ǰҳ      ��ҳ��   ��һҳ
	 * 
	 * 1      3    2
	 * 2      3    3
	 * 3      3    3
	 */
	private Integer nextPage;
	
	/**
	 * ��ҳ��
	 * totalpage=(totalCount%pageCount==0?totalCount/pageCount:totalCount/pageCount+1)
	 * pageCount��ÿҳ��ʾ��������   totalCount����������  totalpage������ҳ����
	 * 10                       21              3
	 */
	private Integer totalPage;
	/**
	 * �������������ݿ��ѯ��
	 */
	private Integer total;
	
	/**
	 * �洢����ȡ��������
	 */
	private List rows;

	public Integer getCurPage() {
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public Integer getPageCount() {
		return pageCount;
		
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getPrePage() {
		return prePage;
	}

	public void setPrePage(Integer prePage) {
		this.prePage = prePage;
	}

	public Integer getNextPage() {
		return nextPage;
	}

	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalpage(Integer totalpage) {
		this.totalPage = totalpage;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	
}
