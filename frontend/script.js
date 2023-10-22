document.addEventListener("DOMContentLoaded", function () {
    const itemForm = document.getElementById("itemForm");
    const responseDiv = document.getElementById("response");
    const openModalButton = document.getElementById("openModalButton");
    const closeModalButton = document.getElementById("closeModalButton");
    const modal = document.getElementById("modal");

    openModalButton.addEventListener("click", function () {
        modal.style.display = "block";
    });

    closeModalButton.addEventListener("click", function () {
        modal.style.display = "none";
    });

    itemForm.addEventListener("submit", function (event) {
        event.preventDefault();

        const id = document.getElementById("id").value;
        const name = document.getElementById("name").value;
        const quantity = parseInt(document.getElementById("quantity").value);
        const category = document.getElementById("category").value;

        const itemData = {
            id: id,
            name: name,
            quantity: quantity,
            category: category,
        };

        fetch("http://0.0.0.0/backend/documents", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(itemData),
        })
            .then((response) => response.json())
            .then((data) => {
                responseDiv.textContent = "POST request successful. Response: " + JSON.stringify(data);
            })
            .catch((error) => {
                responseDiv.textContent = "Error: " + error;
            });
    });
});
