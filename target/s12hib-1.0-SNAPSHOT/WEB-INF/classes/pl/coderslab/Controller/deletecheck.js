let deleteCheck = document.querySelector(".delete");

deleteCheck.onclick = function() {
    let result = confirm("Czy na pewno chcesz usunąć ten element?");
    if (result) {
        //tutaj wykonaj kod usuwający element
        window.location.replace("http://localhost:8080/book/delete/${id}")
    } else {
        //tutaj wykonaj kod anulujący usuwanie
        window.location.replace("http://localhost:8080/books")
    }
}