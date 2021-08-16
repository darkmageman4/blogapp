import fetchData from "../fetchData.js";
import createView from "../createView.js";



export default function PostIndex(props) {
    return `
        <header>
            <h1>Posts Page</h1>
        </header>
        
        <main>
<!--        MAKE CREATE FORM HERE-->

<form>

    <label for="title">Title</label>
    <input id="title" name="title" type="text">
    <br>
    <label for="content">Content</label>
    <input id="content" name="content" type="text">
    
        <br>
    <input type="button" name="Submit" id="create-post-btn" value="Add Posts">
</form>



<!--//TODO:In the export default function PostIndex, use the current code to add new elements (with the post's content). Test to see if you have additional properties!-->
 
<br>
            
            <div>
                ${props.posts.map(post => `

<h3 id="${post.id}">${post.title}</h3>

<h2>${post.content}</h2>

<!--//TODO: In PostIndex, above where your posts are rendered but inside the html, add a form for creating a new post-->


<!--edit button, -->
    <input type="button" data-id="${post.id}" class="edit-post-btn" value="Edit">
    
    <!--delete button-->
    <input type="button" data-id="${post.id}" class="delete-post-btn" value="Delete">

`)
        .join('')}   
            </div>
        </main>
    `;

}

PostEvent()

export function PostEvent() {
    createPostEvents()
    editPostEvent()
}


export function createPostEvents() {
    $('#create-post-btn').click(function () {

        let post = {
            title: $("#title").val(),
            content: $("#content").val()
        }
        console.log(post)

        let request = {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(post)
        }

        fetchData({
                posts: '/api/posts'
            },
            request)

    });

}

// function editPostEvent() {
//     $('.edit-post-btn').click(function () {
//
//         let post = {
//             title: $("#title").val(),
//             content: $("#content").val()
//         }
//         console.log(post)
//
//         let request = {
//             method: 'PUT',
//             headers: {'Content-Type': 'application/json'},
//             body: JSON.stringify(post)
//         }
//
//         fetchData({
//                 posts: `/api/posts/${this.attr(`data-id`)}`
//             },
//             request).then(res => {
//             console.log(res.status);
//             createView("/posts")
//         }).catch(error => {
//             console.log(error);
//             createView("/")
//         })
//
//     });


    function editPostEvent (){
        $(".edit-post-btn").click(function (){

            $(".edit-title, .edit-content").attr("contenteditable",false);
            $(".edit-post-btn").text("Edit");

            $(this).siblings(".edit-title, .edit-content").attr("contenteditable",true);
            $(this).text("Save");

            let post = {
                title: $(this).siblings(".edit-title").text(),
                content: $(this).siblings(".edit-content").text(),
            }
        })

        $(this).off("click",submitEditEvent)
        let id = $(this).attr("data-id")
        fetch(`http://localhost:8080/api/posts/${id}`,request)
            .then(res => {
            console.log(res.status);
            createView("/posts")
        }).catch(error => {
            console.log(error);
            createView("/")
    }



    function submitEditEvent(){

        let post = {
            title: $(this).siblings(".edit-title").text(),
            content: $(this).siblings(".edit-content").text(),
        }

        let request = {
            method: 'PUT',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(post)
        }
    }

        function deleteEvent(){
            $(".delete-btn").click(function (){

                let request = {
                    method: "DELETE",
                    headers: {"Content-Type": "application/json"},
                }

                fetch(`http://localhost:8080/api/posts/${id}`, request)
                    .then(res => {
                        console.log(res.status);
                        createView("/posts");
                    })
                    .catch(error => {
                        console.log(error)
                        createView("/posts")
                    })
            })
        }
}



