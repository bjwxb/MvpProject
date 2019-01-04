package com.wxb.mvp.bean.success;

import java.util.List;

public class MallUserInfoBean {

    /**
     * status : success
     * data : {"user":{"username":"admin1","name":"鹳狸猿","sex":"FEMALE","avatar":"avatar url","departmentName":"心内科","tel":"15800000000","expertise":"个人擅长","biography":"个人简介","experience":"个人经历","certificates":[{"imageIds":["test"],"type":"PROFESSION_CERT"},{"imageIds":["xxx"],"type":"BADGE"}],"roles":["DOCTOR"],"status":"PENDING","inviteStatus":"CONFIRMED","qrCodeUrl":null,"meetingLecture":"会议与讲课","hospitalIntroduction":"所属医院","firstProfessionCompany":"第一职业单位","goodsDescriptions":[{"goodsId":"123","price":"123","category":"SUPERIOR_VIP","type":"CONSULTATION_24","canModify":true}],"unAcceptEndTime":1111111,"consultationAcceptStatus":"NO_CONSULTATION","departmentCategory":null,"organizationId":null},"institution":{"id":"8XBZKr","name":"动物园医院"},"department":{"id":"20sslflw","name":"禽流感科","category":null,"status":null,"assistantCount":10,"doctorCount":0,"patientCount":0,"operatorCount":0},"reviewOrgId":"8Vbvm8","relationship":[{"organizationId":"8XBZKr","organizationName":"科技馆","departmentId":"8XBZKr","status":"CONFIRMED","qrCodeUrl":"二维码地址","role":"DOCTOR","depCategory":"CARDIOVASCULAR","unAcceptEndTime":null,"consultationAcceptStatus":null,"consultationExpireTimeStatus":null}],"defaultDoctor":false}
     */

    private String status;
    private DataBean data;
    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * user : {"username":"admin1","name":"鹳狸猿","sex":"FEMALE","avatar":"avatar url","departmentName":"心内科","tel":"15800000000","expertise":"个人擅长","biography":"个人简介","experience":"个人经历","certificates":[{"imageIds":["test"],"type":"PROFESSION_CERT"},{"imageIds":["xxx"],"type":"BADGE"}],"roles":["DOCTOR"],"status":"PENDING","inviteStatus":"CONFIRMED","qrCodeUrl":null,"meetingLecture":"会议与讲课","hospitalIntroduction":"所属医院","firstProfessionCompany":"第一职业单位","goodsDescriptions":[{"goodsId":"123","price":"123","category":"SUPERIOR_VIP","type":"CONSULTATION_24","canModify":true}],"unAcceptEndTime":1111111,"consultationAcceptStatus":"NO_CONSULTATION","departmentCategory":null,"organizationId":null}
         * institution : {"id":"8XBZKr","name":"动物园医院"}
         * department : {"id":"20sslflw","name":"禽流感科","category":null,"status":null,"assistantCount":10,"doctorCount":0,"patientCount":0,"operatorCount":0}
         * reviewOrgId : 8Vbvm8
         * relationship : [{"organizationId":"8XBZKr","organizationName":"科技馆","departmentId":"8XBZKr","status":"CONFIRMED","qrCodeUrl":"二维码地址","role":"DOCTOR","depCategory":"CARDIOVASCULAR","unAcceptEndTime":null,"consultationAcceptStatus":null,"consultationExpireTimeStatus":null}]
         * defaultDoctor : false
         */

        private UserBean user;
        private InstitutionBean institution;
        private DepartmentBean department;
        private String reviewOrgId;
        private boolean defaultDoctor;
        private List<RelationshipBean> relationship;

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public InstitutionBean getInstitution() {
            return institution;
        }

        public void setInstitution(InstitutionBean institution) {
            this.institution = institution;
        }

        public DepartmentBean getDepartment() {
            return department;
        }

        public void setDepartment(DepartmentBean department) {
            this.department = department;
        }

        public String getReviewOrgId() {
            return reviewOrgId;
        }

        public void setReviewOrgId(String reviewOrgId) {
            this.reviewOrgId = reviewOrgId;
        }

        public boolean isDefaultDoctor() {
            return defaultDoctor;
        }

        public void setDefaultDoctor(boolean defaultDoctor) {
            this.defaultDoctor = defaultDoctor;
        }

        public List<RelationshipBean> getRelationship() {
            return relationship;
        }

        public void setRelationship(List<RelationshipBean> relationship) {
            this.relationship = relationship;
        }

        public static class UserBean {
            /**
             * username : admin1
             * name : 鹳狸猿
             * sex : FEMALE
             * avatar : avatar url
             * departmentName : 心内科
             * tel : 15800000000
             * expertise : 个人擅长
             * biography : 个人简介
             * experience : 个人经历
             * certificates : [{"imageIds":["test"],"type":"PROFESSION_CERT"},{"imageIds":["xxx"],"type":"BADGE"}]
             * roles : ["DOCTOR"]
             * status : PENDING
             * inviteStatus : CONFIRMED
             * qrCodeUrl : null
             * meetingLecture : 会议与讲课
             * hospitalIntroduction : 所属医院
             * firstProfessionCompany : 第一职业单位
             * goodsDescriptions : [{"goodsId":"123","price":"123","category":"SUPERIOR_VIP","type":"CONSULTATION_24","canModify":true}]
             * unAcceptEndTime : 1111111
             * consultationAcceptStatus : NO_CONSULTATION
             * departmentCategory : null
             * organizationId : null
             */

            private String username;
            private String name;
            private String sex;
            private String avatar;
            private String departmentName;
            private String tel;
            private String expertise;
            private String biography;
            private String experience;
            private String status;
            private String inviteStatus;
            private Object qrCodeUrl;
            private String meetingLecture;
            private String hospitalIntroduction;
            private String firstProfessionCompany;
            private long unAcceptEndTime;
            private String consultationAcceptStatus;
            private Object departmentCategory;
            private Object organizationId;
            private List<CertificatesBean> certificates;
            private List<String> roles;
            private List<GoodsDescriptionsBean> goodsDescriptions;

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getDepartmentName() {
                return departmentName;
            }

            public void setDepartmentName(String departmentName) {
                this.departmentName = departmentName;
            }

            public String getTel() {
                return tel;
            }

            public void setTel(String tel) {
                this.tel = tel;
            }

            public String getExpertise() {
                return expertise;
            }

            public void setExpertise(String expertise) {
                this.expertise = expertise;
            }

            public String getBiography() {
                return biography;
            }

            public void setBiography(String biography) {
                this.biography = biography;
            }

            public String getExperience() {
                return experience;
            }

            public void setExperience(String experience) {
                this.experience = experience;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getInviteStatus() {
                return inviteStatus;
            }

            public void setInviteStatus(String inviteStatus) {
                this.inviteStatus = inviteStatus;
            }

            public Object getQrCodeUrl() {
                return qrCodeUrl;
            }

            public void setQrCodeUrl(Object qrCodeUrl) {
                this.qrCodeUrl = qrCodeUrl;
            }

            public String getMeetingLecture() {
                return meetingLecture;
            }

            public void setMeetingLecture(String meetingLecture) {
                this.meetingLecture = meetingLecture;
            }

            public String getHospitalIntroduction() {
                return hospitalIntroduction;
            }

            public void setHospitalIntroduction(String hospitalIntroduction) {
                this.hospitalIntroduction = hospitalIntroduction;
            }

            public String getFirstProfessionCompany() {
                return firstProfessionCompany;
            }

            public void setFirstProfessionCompany(String firstProfessionCompany) {
                this.firstProfessionCompany = firstProfessionCompany;
            }

            public long getUnAcceptEndTime() {
                return unAcceptEndTime;
            }

            public void setUnAcceptEndTime(long unAcceptEndTime) {
                this.unAcceptEndTime = unAcceptEndTime;
            }

            public String getConsultationAcceptStatus() {
                return consultationAcceptStatus;
            }

            public void setConsultationAcceptStatus(String consultationAcceptStatus) {
                this.consultationAcceptStatus = consultationAcceptStatus;
            }

            public Object getDepartmentCategory() {
                return departmentCategory;
            }

            public void setDepartmentCategory(Object departmentCategory) {
                this.departmentCategory = departmentCategory;
            }

            public Object getOrganizationId() {
                return organizationId;
            }

            public void setOrganizationId(Object organizationId) {
                this.organizationId = organizationId;
            }

            public List<CertificatesBean> getCertificates() {
                return certificates;
            }

            public void setCertificates(List<CertificatesBean> certificates) {
                this.certificates = certificates;
            }

            public List<String> getRoles() {
                return roles;
            }

            public void setRoles(List<String> roles) {
                this.roles = roles;
            }

            public List<GoodsDescriptionsBean> getGoodsDescriptions() {
                return goodsDescriptions;
            }

            public void setGoodsDescriptions(List<GoodsDescriptionsBean> goodsDescriptions) {
                this.goodsDescriptions = goodsDescriptions;
            }

            public static class CertificatesBean {
                /**
                 * imageIds : ["test"]
                 * type : PROFESSION_CERT
                 */

                private String type;
                private List<String> imageIds;

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public List<String> getImageIds() {
                    return imageIds;
                }

                public void setImageIds(List<String> imageIds) {
                    this.imageIds = imageIds;
                }
            }

            public static class GoodsDescriptionsBean {
                /**
                 * goodsId : 123
                 * price : 123
                 * category : SUPERIOR_VIP
                 * type : CONSULTATION_24
                 * canModify : true
                 */

                private String goodsId;
                private String price;
                private String category;
                private String type;
                private boolean canModify;

                public String getGoodsId() {
                    return goodsId;
                }

                public void setGoodsId(String goodsId) {
                    this.goodsId = goodsId;
                }

                public String getPrice() {
                    return price;
                }

                public void setPrice(String price) {
                    this.price = price;
                }

                public String getCategory() {
                    return category;
                }

                public void setCategory(String category) {
                    this.category = category;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public boolean isCanModify() {
                    return canModify;
                }

                public void setCanModify(boolean canModify) {
                    this.canModify = canModify;
                }
            }
        }

        public static class InstitutionBean {
            /**
             * id : 8XBZKr
             * name : 动物园医院
             */

            private String id;
            private String name;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class DepartmentBean {
            /**
             * id : 20sslflw
             * name : 禽流感科
             * category : null
             * status : null
             * assistantCount : 10
             * doctorCount : 0
             * patientCount : 0
             * operatorCount : 0
             */

            private String id;
            private String name;
            private Object category;
            private Object status;
            private int assistantCount;
            private int doctorCount;
            private int patientCount;
            private int operatorCount;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Object getCategory() {
                return category;
            }

            public void setCategory(Object category) {
                this.category = category;
            }

            public Object getStatus() {
                return status;
            }

            public void setStatus(Object status) {
                this.status = status;
            }

            public int getAssistantCount() {
                return assistantCount;
            }

            public void setAssistantCount(int assistantCount) {
                this.assistantCount = assistantCount;
            }

            public int getDoctorCount() {
                return doctorCount;
            }

            public void setDoctorCount(int doctorCount) {
                this.doctorCount = doctorCount;
            }

            public int getPatientCount() {
                return patientCount;
            }

            public void setPatientCount(int patientCount) {
                this.patientCount = patientCount;
            }

            public int getOperatorCount() {
                return operatorCount;
            }

            public void setOperatorCount(int operatorCount) {
                this.operatorCount = operatorCount;
            }
        }

        public static class RelationshipBean {
            /**
             * organizationId : 8XBZKr
             * organizationName : 科技馆
             * departmentId : 8XBZKr
             * status : CONFIRMED
             * qrCodeUrl : 二维码地址
             * role : DOCTOR
             * depCategory : CARDIOVASCULAR
             * unAcceptEndTime : null
             * consultationAcceptStatus : null
             * consultationExpireTimeStatus : null
             */

            private String organizationId;
            private String organizationName;
            private String departmentId;
            private String status;
            private String qrCodeUrl;
            private String role;
            private String depCategory;
            private Object unAcceptEndTime;
            private Object consultationAcceptStatus;
            private Object consultationExpireTimeStatus;

            public String getOrganizationId() {
                return organizationId;
            }

            public void setOrganizationId(String organizationId) {
                this.organizationId = organizationId;
            }

            public String getOrganizationName() {
                return organizationName;
            }

            public void setOrganizationName(String organizationName) {
                this.organizationName = organizationName;
            }

            public String getDepartmentId() {
                return departmentId;
            }

            public void setDepartmentId(String departmentId) {
                this.departmentId = departmentId;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getQrCodeUrl() {
                return qrCodeUrl;
            }

            public void setQrCodeUrl(String qrCodeUrl) {
                this.qrCodeUrl = qrCodeUrl;
            }

            public String getRole() {
                return role;
            }

            public void setRole(String role) {
                this.role = role;
            }

            public String getDepCategory() {
                return depCategory;
            }

            public void setDepCategory(String depCategory) {
                this.depCategory = depCategory;
            }

            public Object getUnAcceptEndTime() {
                return unAcceptEndTime;
            }

            public void setUnAcceptEndTime(Object unAcceptEndTime) {
                this.unAcceptEndTime = unAcceptEndTime;
            }

            public Object getConsultationAcceptStatus() {
                return consultationAcceptStatus;
            }

            public void setConsultationAcceptStatus(Object consultationAcceptStatus) {
                this.consultationAcceptStatus = consultationAcceptStatus;
            }

            public Object getConsultationExpireTimeStatus() {
                return consultationExpireTimeStatus;
            }

            public void setConsultationExpireTimeStatus(Object consultationExpireTimeStatus) {
                this.consultationExpireTimeStatus = consultationExpireTimeStatus;
            }
        }
    }
}
