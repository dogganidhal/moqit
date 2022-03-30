package io.moqit.service.content;


public class IPAddressContentSource implements ContentSource {

  private final static short MAX_IP_FIELD_VALUE = 255;

  @Override
  public String getOne() {
    return getRandomShort() + "." + getRandomShort() + "." + getRandomShort() + "." + getRandomShort();
  }

  private short getRandomShort() {
    return (short) (Math.random() * MAX_IP_FIELD_VALUE);
  }

}
