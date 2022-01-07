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
import java.util.Objects;
import java.util.StringJoiner;

public class UpdateGiftCertificateDto extends RepresentationModel<UpdateGiftCertificateDto> {

    private long id;
    @Size(min = 1, max = 128, message = "Name length should be >= 1 and  <= 128")
    private String name;
    @Size(max = 256, message = "Description length should be >= 1 and <= 256")
    private String description;
    @Min(1)
    private BigDecimal price;
    @Min(1)
    private int duration;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private ZonedDateTime createDate;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private ZonedDateTime lastUpdateDate;
    private List<TagDto> tagList;

    /**
     * Instantiates a new Update gift certificate dto.
     * Used for mapper.
     */
    public UpdateGiftCertificateDto() {}

    public UpdateGiftCertificateDto(
            long id,
            @Size(max = 128, message = "Name length should be <= 128") String name,
            @Size(max = 256, message = "Description length should be >= 1 and <= 256") String description,
            @Min(1) BigDecimal price,
            @Min(1) int duration,
            ZonedDateTime createDate, ZonedDateTime lastUpdateDate, List<TagDto> tagDtoList
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
        this.tagList = tagDtoList;
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

    public void setName(@Size(min = 1, max = 128) String name) {
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

    public List<TagDto> getTagList() {
        return tagList;
    }

    public void setTagList(List<TagDto> tagList) {
        this.tagList = tagList;
    }

    public void addTag(TagDto tagDto) {
        if (tagList == null) {
            tagList = new ArrayList<>();
        }
        tagList.add(tagDto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UpdateGiftCertificateDto that = (UpdateGiftCertificateDto) o;
        return id == that.id && duration == that.duration
                && Objects.equals(name, that.name)
                && Objects.equals(description, that.description)
                && Objects.equals(price, that.price)
                && Objects.equals(createDate, that.createDate)
                && Objects.equals(lastUpdateDate, that.lastUpdateDate)
                && Objects.equals(tagList, that.tagList);
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
        result = 31 * result + (tagList != null ? tagList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UpdateGiftCertificateDto.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("description='" + description + "'")
                .add("price=" + price)
                .add("duration=" + duration)
                .add("createDate=" + createDate)
                .add("lastUpdateDate=" + lastUpdateDate)
                .add("tagDtoList=" + tagList)
                .toString();
    }
}
