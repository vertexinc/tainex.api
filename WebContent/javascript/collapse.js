 $(document).ready(function () {
        $('a[data-toggle="collapse"]').click(function () {
          $(this).find('span.toggle-icon').toggleClass('glyphicon-chevron-down glyphicon-chevron-up');
        })
      })