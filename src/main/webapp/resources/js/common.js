
$(function () {
    // menu toggle
    $(".ico_menu").on("click", function () {
        if ($(".side_menu").hasClass("active")) {
            $(".side_menu").removeClass("active");
            
            $(".modal").hide();
        } else {
            $(".side_menu").addClass("active");
            $(".modal").show();
        }
    });

    // modal close
    $(".modal").on("click", function () {
        $(".side_menu").removeClass("active");
        $(".modal").hide();
        $(".layer_popup").hide();
    });

    // menu close
    $(".close_menu").on("click", function () {
        $(".side_menu").removeClass("active");
        $(".modal").hide();
    });

    // service toggle
    $("#notice > ul > li").on("click", function () {
        const url = $(this).data("url");
        if (url == "service") {
            if ($(".service_sub").hasClass("active")) {
                $(".service_sub").removeClass("active");
            } else {
                $(".service_sub").addClass("active");
            }

        } else {
			if (url == "home") {
				location.href = contextPath;
			} else {
				
            alert(url);
			}
        }
    });

    // service location href
    $("#notice > ul > li .service_sub > li").on("click", function () {
        const url = $(this).data("url");
		alert(url);
    });
});