package com.luowei.virusmap.dao;

import com.luowei.virusmap.domain.VirusdataView;
import com.luowei.virusmap.domain.VirusdataViewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VirusdataViewMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table virusdata_view
     *
     * @mbg.generated
     */
    long countByExample(VirusdataViewExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table virusdata_view
     *
     * @mbg.generated
     */
    int deleteByExample(VirusdataViewExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table virusdata_view
     *
     * @mbg.generated
     */
    int insert(VirusdataView record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table virusdata_view
     *
     * @mbg.generated
     */
    int insertSelective(VirusdataView record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table virusdata_view
     *
     * @mbg.generated
     */
    VirusdataView selectOneByExample(VirusdataViewExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table virusdata_view
     *
     * @mbg.generated
     */
    VirusdataView selectOneByExampleSelective(@Param("example") VirusdataViewExample example, @Param("selective") VirusdataView.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table virusdata_view
     *
     * @mbg.generated
     */
    List<VirusdataView> selectByExampleSelective(@Param("example") VirusdataViewExample example, @Param("selective") VirusdataView.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table virusdata_view
     *
     * @mbg.generated
     */
    List<VirusdataView> selectByExample(VirusdataViewExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table virusdata_view
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") VirusdataView record, @Param("example") VirusdataViewExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table virusdata_view
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") VirusdataView record, @Param("example") VirusdataViewExample example);
}