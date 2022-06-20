package com.swb.springbootempall.mapper;

        import com.baomidou.mybatisplus.core.mapper.BaseMapper;
        import com.baomidou.mybatisplus.core.metadata.IPage;
        import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
        import com.swb.springbootempall.entity.Emp;
        import org.apache.ibatis.annotations.Param;

        import java.util.Map;

/**
 * @title: EmpMapper
 * @author: 流沐颖
 * @date:2022/6/17 18:54
 * @description:
 * @version: study
 */
public interface EmpMapper extends BaseMapper<Emp> {
    /**
     * 根据查询条件进行查询
     * @param page
     * @param map
     * @return
     */
    IPage<Emp> empPage(@Param("page") Page<Emp> page, @Param("map") Map<String, Object> map);
}
