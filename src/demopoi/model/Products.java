/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demopoi.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author cjuan
 */
@Entity
@Table(name = "products")
@NamedQueries({
    @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p"),
    @NamedQuery(name = "Products.findById", query = "SELECT p FROM Products p WHERE p.id = :id"),
    @NamedQuery(name = "Products.findByName", query = "SELECT p FROM Products p WHERE p.name = :name"),
    @NamedQuery(name = "Products.findByTag", query = "SELECT p FROM Products p WHERE p.tag = :tag"),
    @NamedQuery(name = "Products.findByNumberSerie", query = "SELECT p FROM Products p WHERE p.numberSerie = :numberSerie"),
    @NamedQuery(name = "Products.findByProductInformation", query = "SELECT p FROM Products p WHERE p.productInformation = :productInformation"),
    @NamedQuery(name = "Products.findByPrice", query = "SELECT p FROM Products p WHERE p.price = :price"),
    @NamedQuery(name = "Products.findBySize", query = "SELECT p FROM Products p WHERE p.size = :size"),
    @NamedQuery(name = "Products.findByColor", query = "SELECT p FROM Products p WHERE p.color = :color"),
    @NamedQuery(name = "Products.findByMaterial", query = "SELECT p FROM Products p WHERE p.material = :material"),
    @NamedQuery(name = "Products.findByBanner", query = "SELECT p FROM Products p WHERE p.banner = :banner"),
    @NamedQuery(name = "Products.findByDescription", query = "SELECT p FROM Products p WHERE p.description = :description"),
    @NamedQuery(name = "Products.findByExpirate", query = "SELECT p FROM Products p WHERE p.expirate = :expirate"),
    @NamedQuery(name = "Products.findByProduct", query = "SELECT p FROM Products p WHERE p.product = :product"),
    @NamedQuery(name = "Products.findByStatus", query = "SELECT p FROM Products p WHERE p.status = :status"),
    @NamedQuery(name = "Products.findBySubtitle", query = "SELECT p FROM Products p WHERE p.subtitle = :subtitle"),
    @NamedQuery(name = "Products.findByTitle", query = "SELECT p FROM Products p WHERE p.title = :title")})
public class Products implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "tag")
    private String tag;
    @Column(name = "number_serie")
    private Integer numberSerie;
    @Column(name = "product_information")
    private String productInformation;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Double price;
    @Column(name = "size")
    private String size;
    @Column(name = "color")
    private String color;
    @Column(name = "material")
    private String material;
    @Column(name = "banner")
    private String banner;
    @Column(name = "description")
    private String description;
    @Column(name = "expirate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirate;
    @Basic(optional = false)
    @Column(name = "product")
    private int product;
    @Column(name = "status")
    private String status;
    @Column(name = "subtitle")
    private String subtitle;
    @Column(name = "title")
    private String title;
    @JoinColumn(name = "category", referencedColumnName = "id")
    @ManyToOne
    private Categorys category;

    public Products() {
    }

    public Products(Integer id) {
        this.id = id;
    }

    public Products(Integer id, int product) {
        this.id = id;
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getNumberSerie() {
        return numberSerie;
    }

    public void setNumberSerie(Integer numberSerie) {
        this.numberSerie = numberSerie;
    }

    public String getProductInformation() {
        return productInformation;
    }

    public void setProductInformation(String productInformation) {
        this.productInformation = productInformation;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getExpirate() {
        return expirate;
    }

    public void setExpirate(Date expirate) {
        this.expirate = expirate;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Categorys getCategory() {
        return category;
    }

    public void setCategory(Categorys category) {
        this.category = category;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "demopoi.util.Products[ id=" + id + " ]";
    }
    
}
