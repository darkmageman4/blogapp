import fetchData from "../fetchData.js";
import createView from "../createView.js";

export default function PostIndex(props) {
    return `
        <header>
            <h1>Posts Page</h1>
        </header>
        <main>
<!--MAKE CREATE FORM HERE--> 
       <form>

    <label for="title">Title</label>
    <input id="title" name="title" type="text">
    <br>

    <label for="content">Content</label>
    <input id="content" name="content" type="content">
    <br>

    <input type="button" id="create-post-btn" value="Add-Post">
</form>
            
            <div class="post-container">
                ${props.posts.map(post =>
        `
                     
                        <div>
                        
                        <input class="edit-title" value="${post.title}" readonly>
                        <input class="edit-content"  value="${post.content}" readonly>
                       
                    
                        <button  class="edit-post-btn" type="button" data-id="${post.id}">Edit</button>
                     
                        <button data-id=${post.id} class="delete-post-btn">Delete</button>
                        </div>
       <!--add edit, delete buttons, add edit form-->
        
        
        `).join('')}   
            </div>
            
            
        </main>
    `;
}


export function PostsEvent() {
    createPostEvent();
    editEvent();

}

function createPostEvent() {
    $(`#create-post-btn`).click(function () {


            let post = {
                title: $("#title").val(),
                content: $("#content").val(),
            }
            console.log(post)

            let request = {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',

                },
                body: JSON.stringify(post)
            }
            // fetchData({
            //         posts: '/api/posts'
            //     },
            //     request)
            fetch("http://localhost:8080/api/posts/", request)
                .then(res => {
                    console.log(res.status);
                    createView("/posts");
                }).catch(error => {
                console.log(error);
                createPostEvent("/posts")
            })
        }
    )
    ;


}


function editEvent() {
    $(".edit-post-btn").click(function () {
        console.log("event fired off")
        $(".edit-post-btn").text("Edit");
        $(".edit-title, .edit-content").attr("readonly", true);
        $(this).siblings(".edit-title, .edit-content").attr("readonly", false);
        $(this).text("Save");


        $(this).on("click", submitEditEvent)

    })
}

function submitEditEvent() {
    let post = {
        title: $(this).siblings("edit-title").text(),
        content: $(this).siblings("edit-content").text()
    }
    let request = {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',

        },
        body: JSON.stringify(post)
    }

    console.log(post)

    $(this).off("click", submitEditEvent)
    let id = $(this).attr("data-id")
    fetch(`http://localhost:8080/api/posts/${id}`, request)
        .then(res => {
            console.log(res.status);
            createView("/posts");
        }).catch(error => {
        console.log(error);
        createPostEvent("/posts")
    })

    function deleteEvent() {
        $(".delete-post-btn").click(function () {
            let request = {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json'
                },
            }
            let id = $(this).attr("data-id")
            fetch(`http://localhost:8080/api/posts/${id}`, request)
                .then(res => {
                    console.log(res.status);
                    createView("/posts");
                }).catch(error => {
                console.log(error);
                createView("/posts")
            })


        })

    }

}