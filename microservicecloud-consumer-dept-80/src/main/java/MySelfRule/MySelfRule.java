package MySelfRule;


import org.springframework.context.annotation.Bean;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

public class MySelfRule {

	@Bean
	public IRule myRule() {
		//return new RandomRule();//自定义随机算法
		return new  MyRandomRule();//指定LoadBalanced的算法 用我们自定义的规则算法
	}
}
