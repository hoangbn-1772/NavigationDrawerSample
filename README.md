# Navigation Drawer

## Overview
### Notification Drawer là gì?
- Navigation Drawer là một menu kéo, cung cấp quyền truy cập vào các điểm đến trong ứng dụng.
- Click icon hoặc có thể vuốt từ trái sang để hiển thị. Và khi không sử dụng nó sẽ ẩn đi.
- Navigation Drawer có thể hiện thị vĩnh viễn trên màn hình hoặc được điều khiển bằng icon menu navigation.
### Khi nào nên sử dụng Navigation Drawer
- App có từ 5 tab trở lên.
- App có 2 hoặc nhiều phân cấp điều hướng
- Điều hướng nhanh giữa 2 điểm đến không liên quan đến nhau.

<img src="images/drawer_5_des.png"/>

- Chú ý: Tránh sử dụng Navigation Drawer với một thành phần điều hường chính khác, như là Bottom navigation.

<img src="images/drawer_with_bottom.png"/>

### Nguyên tắc
- Vị trí và kiểu danh sách nội dung của Navigation Drawer định nghĩa rõ ràng.
- Sắp xếp các điểm đến theo mức độ quan trọng của người dùng: Các destination thường sử dụng trước, nhóm các destination có liên quan với nhau.
- Có thể ẩn hoặc hiện để hiện thị những bố cục khác app.

### Navigation drawer types
- Standard drawer:
	+ cho phép users truy cập đồng thời drawer destinations và nội dung app. Chúng thường cùng cấp với nội dung app và có ảnh hưởng đến bố cục màn hình.
	+ Có thể hiển thị vĩnh viễn hoặc đóng/mở bằng cách tapping vào navigation menu icon.
	+ Chỉ có thể sử dụng trên tablet và desktop, với mobile sử dụng modal drawers thay thế.

	<img src="images/standard_drawer.png"/>

- Modal drawer:
	+ Sử dụng một scrim để chặn tương tác với phần còn lại của nội dung app, không ảnh hưởng đến bố cục màn hình
	+ Chủ yếu sử dụng trên thiết bị di động, nơi không gian màn hình bị hạn chế.
	
	<img src="images/modal_drawer.png"/>

- Bottom drawer:
	+ Là một drawer chuyên dụng được sử dụng cùng với bottom app bar.
	+ Xuất hiện từ dưới lên.
	
	<img src="images/bottom_drawer.png"/>

### Thành phần

<img src="images/navigation_drawer_elements.png"/>

- 1: Container
- 2: Header (optional)
- 3: Divider (optional)
- 4: Active text overlay
- 5: Active text
- 6: Inactive text
- 7: Subtitle
- 8: Scrim (modal only)

#### Header (optional)
- Là một không gian linh hoạt có thể sử dụng để thể hiện thương hiệu (tiêu đề úng dụng, logo,...), chuyển đổi account và hơn thế nữa.

<img src="images/header.png"/>

#### Destinations
- Destinations trong navigation drawer có dạng các mục danh sách hành động. Mỗi destination mô tả đích đến của nó bằng text label và icon (optional)
- Destination cùng text label/ text lable + icon: Text labels nên rõ ràng và ngắn gọn.

<img src="images/destination_labels.png"/>

<img src="images/destination_labels.png"/>

- Chú ý:
	+ Icon nên sử dụng cho tất cả destinations hoặc không sử dụng
	+ Destinations thứ cấp có thể được biểu thị cùng một icon.

	<img src="images/destination_secondary.png"/>

#### Dividers (optional)
- Có thể sử dụng để phân tách groups destination

<img src="images/dividers_destination.png"/>

#### Scrim (modal và bottom only)
- Sử dung Scrim để chặn users tương tác với phần còn lại của app.
- Được đặt ngay bên dưới drawer sheet và có thể bấm để loại bỏ drawer.

## Modal drawer
- Modal drawer chặn tương tác với phần còn lại của app bằng scrim, không ảnh hưởng đến bố cục giao diện.
- Sử dụng trên mobile, và có thể thay thế được cho standard drawer trên tablet và desktop.
### Behavior
- Opening: Sử dụng drawer item/ vuốt từ vị trí navigation drawer neo.
- Closing:
	+ Selecting a drawer item
	+ Tapping the scrim
	+ Vuốt về phí drawer neo.
- Scrolling: Nếu danh sách destination dài hơn chiều cao của drawer, có thể cuộc theo chiều dọc drawer.
### Specs

<img src="images/specs_modal_drawer.png"/>

## Bottom drawer
- Là Modal drawer được neo ở dưới cùng thay vì cạnh bên màn hình. Chỉ được sử dụng với bottom app bar.
### Behavior
- Opening (portrait orientation):
	+ Nếu nội dung drawer nhỏ hơn 50% chiều cao, hiển thị đầy đủ drawer
	+ Nếu nội dung drawer lớn hơn 50% chiều cao, hiện thị drawer đến 50% màn hình, cho phép users kéo lên đến toàn bộ chiều cao của nó hoặc full screen height.

	<img src="images/portrait_orientation.png"/>

- Opening (landscape orientation)
	+ Bottom navigation drawer cao hơn sẽ tự động mở sang chế độ full-screen.
- Scrolling: Bottom navigation drawer có thể scroll khi nó đã được mở đến full screen height.
### Specs

<img src="images/specs_bottom_drawer.png"/>

## Implementation

### Triển khai DrawerLayout
- Bên trong DrawerLayout, thêm layout cho main UI và các view khác chứa nội dung của Navigation Drawer.

## Tham kháo
- https://material.io/design/components/navigation-drawer.html#implementation
- https://material.io/develop/android/components/navigation-view/
- https://developer.android.com/reference/android/support/v4/widget/DrawerLayout.html
- https://developer.android.com/guide/navigation/navigation-ui#add_a_navigation_drawer
- https://medium.com/quick-code/android-navigation-drawer-e80f7fc2594f

