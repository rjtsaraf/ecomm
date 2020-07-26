package com.ecommerce.shoppinghub.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.annotation.Transient;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Virender Bhargav
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true, value={ "deletedPaymentReceipt" }, allowSetters=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Slf4j
public class PaymentOrderDto {

    @Null(groups = {Create.class}, message = "Id will be auto-generated")
    private Long id;

    @Null(groups = {Create.class}, message = "orderId will be auto-generated")
    @NotBlank(groups = {Update.class}, message = "orderId is required")
    private String orderId;

    private Long lid;

    private String mid;

    @NotBlank(groups = {Create.class, Update.class}, message = "contactId can not be empty")
    private String contactId;

    private String siteId;

    private String custId;

    private String invoiceUuid;

    private String uniqueReferenceNumber;

    /**
     * this consist of payment mode debit pay info
     * such as net banking transaction Id
     * cheque number
     * subwallet Id
     */
    private String payModeRefNumber;


    private String linkedOrderId;

    /**
     * move this check to validation level as for AP payments amount is null from front-End
     * and amount being computed is equivalent to invoice amount
     */
    @NotNull(groups = {Create.class, Update.class}, message = "amount can not be null")
    @DecimalMax(value = "99999999.0", groups = {Create.class, Update.class}, message = "amount limit exceeded")
    @DecimalMin(value = "1.0", groups = {Create.class, Update.class}, message = "amount less than min required")
    @Digits(integer=8, fraction=2,groups = {Create.class, Update.class}, message = "maximum 8 digits allowed upto "
            + "2 fractions")
    @Null(groups = {PayableCreate.class})
    private BigDecimal amount;

    @Transient
    private String amountInWords;

    private BigDecimal unreconciledAmount;


    /*
     * This will contain unprocessed metaInfo dumped and used by UI
     */
    private String metaInfo;

    /*
     * This will contain additional fields set by User while creating/updated PO
     */
    private String additionalFields;

    /*
     * This will contain the payment related metaInfo like walletName etc (only applicable for AP for now)
     */
//    private Map<String,String> payablePaymentMetaInfo;


    private boolean isActive = true;

    @NotBlank
    @NotNull(groups = {Create.class, Update.class}, message = "paymentDate can not be null")
    public String paymentDate;

    @Size(max = 500,groups = {Create.class, Update.class}, message = "max size reached")
    private String description;


    private String s3Url;

    private Long s3ObjectId;

    private boolean paidViaLink;

    @Transient
    private boolean deletedPaymentReceipt;

    @JsonIgnore
    private String updatedAt;

    @JsonIgnore
    private String createdAt;


    @Transient
    private MultipartFile paymentReceiptFile;

    /*
     * For internal use only
     */
    @JsonIgnore
    private Map<String, String> metaInfoMap = new HashMap<>();


    /*
     * Just a Map representation of metaInfo.CLIENT_INFO
     */
    @Transient
    private Map<String, String> metaInfoJsonObj;

    /*
     * Just a Map representation of metaInfo.ADDITIONAL_FIELDS
     */
    @Transient
    private Map<String, String> additionalFieldsJsonObj;


    /**
     * This interface is used as a group for validating update of Existing instances.
     */
    public interface Update {
    }

    /**
     * This interface is used as a group for validating creation of New instances.
     */
    public interface Create {
    }

    /**
     * This interface is used for validating Vendor Invoice Payment
     */
    public interface PayableCreate {

    }


}

