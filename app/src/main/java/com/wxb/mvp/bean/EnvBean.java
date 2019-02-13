package com.wxb.mvp.bean;

public class EnvBean {
    /**
     * env : released
     * sentry_dsn : https://92e2902108774a60b11fd58e0f2c0c2e:785d3a467c0c4b8aa87c3e5a8ea6bc03@sentry.xinzhili.cn/19
     * lean_cloud : {"app_id":"5v2prFeaNJYNbFaUnrUQIdKu-gzGzoHsz","app_key":"Czytv8kFALRM38D0NIlp8vmw"}
     * lean_cloud_mimu : {"app_id":"2882303761517526565","app_key":"5541752650565"}
     * tts : {"app_id":"11287820","app_key":"Co9G4P7X6r4AA23O6XpG8ZhG","secret_key":"WYDo2Fyma7HIW5VFjC3VGGhNvdalaMlt"}
     */

    private String env;
    private String sentry_dsn;
    private LeanCloudBean lean_cloud;
    private LeanCloudMimuBean lean_cloud_mimu;
    private TtsBean tts;

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getSentry_dsn() {
        return sentry_dsn;
    }

    public void setSentry_dsn(String sentry_dsn) {
        this.sentry_dsn = sentry_dsn;
    }

    public LeanCloudBean getLean_cloud() {
        return lean_cloud;
    }

    public void setLean_cloud(LeanCloudBean lean_cloud) {
        this.lean_cloud = lean_cloud;
    }

    public LeanCloudMimuBean getLean_cloud_mimu() {
        return lean_cloud_mimu;
    }

    public void setLean_cloud_mimu(LeanCloudMimuBean lean_cloud_mimu) {
        this.lean_cloud_mimu = lean_cloud_mimu;
    }

    public TtsBean getTts() {
        return tts;
    }

    public void setTts(TtsBean tts) {
        this.tts = tts;
    }

    public static class LeanCloudBean {
        /**
         * app_id : 5v2prFeaNJYNbFaUnrUQIdKu-gzGzoHsz
         * app_key : Czytv8kFALRM38D0NIlp8vmw
         */

        private String app_id;
        private String app_key;

        public String getApp_id() {
            return app_id;
        }

        public void setApp_id(String app_id) {
            this.app_id = app_id;
        }

        public String getApp_key() {
            return app_key;
        }

        public void setApp_key(String app_key) {
            this.app_key = app_key;
        }
    }

    public static class LeanCloudMimuBean {
        /**
         * app_id : 2882303761517526565
         * app_key : 5541752650565
         */

        private String app_id;
        private String app_key;

        public String getApp_id() {
            return app_id;
        }

        public void setApp_id(String app_id) {
            this.app_id = app_id;
        }

        public String getApp_key() {
            return app_key;
        }

        public void setApp_key(String app_key) {
            this.app_key = app_key;
        }
    }

    public static class TtsBean {
        /**
         * app_id : 11287820
         * app_key : Co9G4P7X6r4AA23O6XpG8ZhG
         * secret_key : WYDo2Fyma7HIW5VFjC3VGGhNvdalaMlt
         */

        private String app_id;
        private String app_key;
        private String secret_key;

        public String getApp_id() {
            return app_id;
        }

        public void setApp_id(String app_id) {
            this.app_id = app_id;
        }

        public String getApp_key() {
            return app_key;
        }

        public void setApp_key(String app_key) {
            this.app_key = app_key;
        }

        public String getSecret_key() {
            return secret_key;
        }

        public void setSecret_key(String secret_key) {
            this.secret_key = secret_key;
        }
    }
}