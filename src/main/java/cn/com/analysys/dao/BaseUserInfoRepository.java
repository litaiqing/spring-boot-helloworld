package cn.com.analysys.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import cn.com.analysys.pojo.BaseUserInfo;

/**
 * Description:
 * <br/>
 *
 * @author litaiqing
 * @version 1.0
 * @date: 2018/7/11 14:09
 * @since JDK 1.8
 */
public interface BaseUserInfoRepository extends JpaRepository<BaseUserInfo, String> {

    Page<BaseUserInfo> findAll(Pageable pageable);

}
