package com.bailu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：wangyunpeng@zhangwen.com
 * @date ：Created in 2021/8/24 10:07
 * @description：
 * @version:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDTO {

    @JsonProperty("name")
    private String username;

    private String avatar;
}
