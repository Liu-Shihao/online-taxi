package con.lsh.common.entity;

import java.util.Date;

public class PassengerMessage {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_passenger_message.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_passenger_message.passenger_info_id
     *
     * @mbggenerated
     */
    private Integer passengerInfoId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_passenger_message.content
     *
     * @mbggenerated
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_passenger_message.if_success
     *
     * @mbggenerated
     */
    private Byte ifSuccess;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_passenger_message.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_passenger_message.update_time
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_passenger_message.id
     *
     * @return the value of tbl_passenger_message.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_passenger_message.id
     *
     * @param id the value for tbl_passenger_message.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_passenger_message.passenger_info_id
     *
     * @return the value of tbl_passenger_message.passenger_info_id
     *
     * @mbggenerated
     */
    public Integer getPassengerInfoId() {
        return passengerInfoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_passenger_message.passenger_info_id
     *
     * @param passengerInfoId the value for tbl_passenger_message.passenger_info_id
     *
     * @mbggenerated
     */
    public void setPassengerInfoId(Integer passengerInfoId) {
        this.passengerInfoId = passengerInfoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_passenger_message.content
     *
     * @return the value of tbl_passenger_message.content
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_passenger_message.content
     *
     * @param content the value for tbl_passenger_message.content
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_passenger_message.if_success
     *
     * @return the value of tbl_passenger_message.if_success
     *
     * @mbggenerated
     */
    public Byte getIfSuccess() {
        return ifSuccess;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_passenger_message.if_success
     *
     * @param ifSuccess the value for tbl_passenger_message.if_success
     *
     * @mbggenerated
     */
    public void setIfSuccess(Byte ifSuccess) {
        this.ifSuccess = ifSuccess;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_passenger_message.create_time
     *
     * @return the value of tbl_passenger_message.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_passenger_message.create_time
     *
     * @param createTime the value for tbl_passenger_message.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_passenger_message.update_time
     *
     * @return the value of tbl_passenger_message.update_time
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_passenger_message.update_time
     *
     * @param updateTime the value for tbl_passenger_message.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
