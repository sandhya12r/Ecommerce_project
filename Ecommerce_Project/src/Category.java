
public class Category {
	private String categoryName;
	private Category [] subCategories;
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Category[] getSubCategories() {
		return subCategories;
	}
	public void setSubCategories(Category[] subCategories) {
		this.subCategories = subCategories;
	}
}
