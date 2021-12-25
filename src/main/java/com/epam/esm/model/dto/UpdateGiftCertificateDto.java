package com.epam.esm.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class UpdateGiftCertificateDto extends RepresentationModel<UpdateGiftCertificateDto> {

    private long id;
    @Size(max = 64, message = "Name length should be >= 1 and  <= 128")
    private String name;
    @Size(max = 100, message = "Description length should be >= 1 and <= 256")
    private String description;
    @Min(0)
    private BigDecimal price;
    @Min(0)
    private int duration;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private ZonedDateTime createDate;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private ZonedDateTime lastUpdateDate;
    private List<TagDto> tagDtoList;

    public UpdateGiftCertificateDto() {}

    public UpdateGiftCertificateDto(
            long id,
            @Size(max = 64, message = "Name length should be <= 128") String name,
            @Size(max = 100, message = "Description length should be >= 1 and <= 256") String description,
            @Min(0) BigDecimal price,
            @Min(0) int duration,
            ZonedDateTime createDate, ZonedDateTime lastUpdateDate, List<TagDto> tagDtoList
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
        this.tagDtoList = tagDtoList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(@Size(min = 1, max = 64) String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(@Size(min = 1, max = 256) String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(@Min(1) BigDecimal price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(@Min(1) int duration) {
        this.duration = duration;
    }

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(ZonedDateTime createDate) {
        this.createDate = createDate;
    }

    public ZonedDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(ZonedDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public List<TagDto> getTagDtoList() {
        return tagDtoList;
    }

    public void setTagDtoList(List<TagDto> tagDtoList) {
        this.tagDtoList = tagDtoList;
    }

    public void addTag(TagDto tagDto) {
        if (tagDtoList == null) {
            tagDtoList = new ArrayList<>();
        }
        tagDtoList.add(tagDto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        UpdateGiftCertificateDto that = (UpdateGiftCertificateDto) o;

        if (id != that.id) return false;
        if (duration != that.duration) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (lastUpdateDate != null ? !lastUpdateDate.equals(that.lastUpdateDate) : that.lastUpdateDate != null)
            return false;
        return tagDtoList != null ? tagDtoList.equals(that.tagDtoList) : that.tagDtoList == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + duration;
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (lastUpdateDate != null ? lastUpdateDate.hashCode() : 0);
        result = 31 * result + (tagDtoList != null ? tagDtoList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GiftCertificateDto{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", price=").append(price);
        sb.append(", duration=").append(duration);
        sb.append(", createDate=").append(createDate);
        sb.append(", lastUpdateDate=").append(lastUpdateDate);
        sb.append(", tagDtoList=").append(tagDtoList);
        sb.append('}');
        return sb.toString();
    }
}