package com.bing.picturelibrary.dto.in;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by bingglewang on 2019/05/16.
 *
 * @author bingglewang
 */
public class IntIdsQuery {
    /**
     * ID数组
     */
    @NotEmpty(message = "至少选择一个")
    private Set<String> ids;

    public List<String> getIds() {
        return new ArrayList<>(ids);
    }
}
