package com.lazulite.mp.config;

import io.github.jhipster.config.JHipsterProperties;
import io.github.jhipster.config.cache.PrefixedKeyGenerator;
import java.time.Duration;
import org.ehcache.config.builders.*;
import org.ehcache.jsr107.Eh107Configuration;
import org.hibernate.cache.jcache.ConfigSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.boot.info.BuildProperties;
import org.springframework.boot.info.GitProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.*;

@Configuration
@EnableCaching
public class CacheConfiguration {
    private GitProperties gitProperties;
    private BuildProperties buildProperties;
    private final javax.cache.configuration.Configuration<Object, Object> jcacheConfiguration;

    public CacheConfiguration(JHipsterProperties jHipsterProperties) {
        JHipsterProperties.Cache.Ehcache ehcache = jHipsterProperties.getCache().getEhcache();

        jcacheConfiguration =
            Eh107Configuration.fromEhcacheCacheConfiguration(
                CacheConfigurationBuilder
                    .newCacheConfigurationBuilder(Object.class, Object.class, ResourcePoolsBuilder.heap(ehcache.getMaxEntries()))
                    .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(ehcache.getTimeToLiveSeconds())))
                    .build()
            );
    }

    @Bean
    public HibernatePropertiesCustomizer hibernatePropertiesCustomizer(javax.cache.CacheManager cacheManager) {
        return hibernateProperties -> hibernateProperties.put(ConfigSettings.CACHE_MANAGER, cacheManager);
    }

    @Bean
    public JCacheManagerCustomizer cacheManagerCustomizer() {
        return cm -> {
            createCache(cm, com.lazulite.mp.repository.UserRepository.USERS_BY_LOGIN_CACHE);
            createCache(cm, com.lazulite.mp.repository.UserRepository.USERS_BY_EMAIL_CACHE);
            createCache(cm, com.lazulite.mp.domain.User.class.getName());
            createCache(cm, com.lazulite.mp.domain.Authority.class.getName());
            createCache(cm, com.lazulite.mp.domain.User.class.getName() + ".authorities");
            createCache(cm, com.lazulite.mp.domain.MicroAppGroup.class.getName());
            createCache(cm, com.lazulite.mp.domain.MicroAppGroup.class.getName() + ".uucDepartmentTrees");
            createCache(cm, com.lazulite.mp.domain.MicroAppGroup.class.getName() + ".uucUserBaseinfos");
            createCache(cm, com.lazulite.mp.domain.MicroAppGroup.class.getName() + ".fmpMicroApps");
            createCache(cm, com.lazulite.mp.domain.FmpMicroApp.class.getName());
            createCache(cm, com.lazulite.mp.domain.FmpMicroApp.class.getName() + ".fmpWidgetInfos");
            createCache(cm, com.lazulite.mp.domain.FmpMicroApp.class.getName() + ".uucDepartmentTrees");
            createCache(cm, com.lazulite.mp.domain.FmpMicroApp.class.getName() + ".usableUsers");
            createCache(cm, com.lazulite.mp.domain.FmpMicroApp.class.getName() + ".fmpSubCompanies");
            createCache(cm, com.lazulite.mp.domain.FmpMicroApp.class.getName() + ".collectionUsers");
            createCache(cm, com.lazulite.mp.domain.FmpMicroApp.class.getName() + ".microAppGroups");
            createCache(cm, com.lazulite.mp.domain.UucDepartmentTree.class.getName());
            createCache(cm, com.lazulite.mp.domain.UucDepartmentTree.class.getName() + ".usables");
            createCache(cm, com.lazulite.mp.domain.UucDepartmentTree.class.getName() + ".managers");
            createCache(cm, com.lazulite.mp.domain.UucDepartmentTree.class.getName() + ".fmpSubCompanies");
            createCache(cm, com.lazulite.mp.domain.UucUserBaseinfo.class.getName());
            createCache(cm, com.lazulite.mp.domain.UucUserBaseinfo.class.getName() + ".collectionFmpMicroApps");
            createCache(cm, com.lazulite.mp.domain.UucUserBaseinfo.class.getName() + ".usableFmpMicroApps");
            createCache(cm, com.lazulite.mp.domain.FmpSubCompany.class.getName());
            createCache(cm, com.lazulite.mp.domain.FmpSubCompany.class.getName() + ".managerUsers");
            createCache(cm, com.lazulite.mp.domain.FmpSubCompany.class.getName() + ".banners");
            createCache(cm, com.lazulite.mp.domain.FmpSubCompany.class.getName() + ".fmpMicroAppTypes");
            createCache(cm, com.lazulite.mp.domain.FmpSubCompany.class.getName() + ".createdApps");
            createCache(cm, com.lazulite.mp.domain.FmpSubCompany.class.getName() + ".microAppGroups");
            createCache(cm, com.lazulite.mp.domain.FmpSubCompany.class.getName() + ".fmpMicroApps");
            createCache(cm, com.lazulite.mp.domain.FmpSubCompany.class.getName() + ".uucDepartmentTrees");
            createCache(cm, com.lazulite.mp.domain.FmpMicroAppType.class.getName());
            createCache(cm, com.lazulite.mp.domain.FmpMicroAppType.class.getName() + ".fmpMicroApps");
            createCache(cm, com.lazulite.mp.domain.FmpWidgetInfo.class.getName());
            createCache(cm, com.lazulite.mp.domain.Banner.class.getName());
            createCache(cm, com.lazulite.mp.domain.DdUser.class.getName());
            createCache(cm, com.lazulite.mp.domain.ManagerUser.class.getName());
            createCache(cm, com.lazulite.mp.domain.ManagerUser.class.getName() + ".uucDepartmentTrees");
            createCache(cm, com.lazulite.mp.domain.PortalRouting.class.getName());
            createCache(cm, com.lazulite.mp.domain.DdUserPortalRouting.class.getName());
            // jhipster-needle-ehcache-add-entry
        };
    }

    private void createCache(javax.cache.CacheManager cm, String cacheName) {
        javax.cache.Cache<Object, Object> cache = cm.getCache(cacheName);
        if (cache == null) {
            cm.createCache(cacheName, jcacheConfiguration);
        }
    }

    @Autowired(required = false)
    public void setGitProperties(GitProperties gitProperties) {
        this.gitProperties = gitProperties;
    }

    @Autowired(required = false)
    public void setBuildProperties(BuildProperties buildProperties) {
        this.buildProperties = buildProperties;
    }

    @Bean
    public KeyGenerator keyGenerator() {
        return new PrefixedKeyGenerator(this.gitProperties, this.buildProperties);
    }
}
