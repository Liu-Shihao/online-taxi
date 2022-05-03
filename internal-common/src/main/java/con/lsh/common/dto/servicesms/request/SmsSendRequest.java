package con.lsh.common.dto.servicesms.request;

import con.lsh.common.dto.servicesms.SmsTemplateDto;
import lombok.Data;

import java.util.Arrays;
import java.util.List;


@Data
public class SmsSendRequest{

	private String[] receivers;
	private List<SmsTemplateDto> data;

	@Override
	public String toString() {
		return "SmsSendRequest [reveivers=" + Arrays.toString(receivers) + ", data=" + data + "]";
	}

}