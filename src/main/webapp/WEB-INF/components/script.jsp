<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<script rel="script" type="application/javascript" src="https://cdn.jsdelivr.net/npm/jquery@4.0.0/dist/jquery.min.js"></script>
<script rel="script" type="application/javascript" src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"></script>
<script rel="script" type="application/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
<script rel="script" type="application/javascript" src="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@7.2.0/js/all.min.js"></script>
<script type="text/javascript">
    let isError = "${isError}";
    if (isError === "true") {
        $("header").hide();
    } else {
        $("header").show();
    }
    let tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'))
    let tooltipList = tooltipTriggerList.map(function (tooltipTriggerEl) {
      return new bootstrap.Tooltip(tooltipTriggerEl)
    });
</script>