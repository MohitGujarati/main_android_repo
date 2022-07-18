package mohit.dev.zomato_clone

class product_ModelClass(
    var img: Int,
    var title: String,
    var rating: String,
    var sub_cat: String,
    var cost: String,
    var time: String,
    var payment_type: Int,
    var discount_amount: Int

    ){}

class Category_ModelClass(
    var cat_img:Int,
    var cat_title:String

){}


class Dining_ModelClass(
    var Rest_name:String,
    var Rest_loc:String,
    var Rest_detailLocation:String,
    var Rest_ratting:Double,
    var Rest_price:Int,
    var Rest_image:Int,


    )

class Combo_ModelClass(
    var combo_img:Int
)

class Hotel_ModelClass(
    var hotel_img:Int,
    var hotel_name:String,
    var hotel_ratting: Double,
)

class Menu_ModelClass(
    var menu_img1:Int,
    var menu_img2:Int,
    var menu_img3:Int,
    var menu_img4:Int,
    var menu_img5:Int,

)