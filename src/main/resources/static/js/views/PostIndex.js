import fetchData from "../fetchData.js";

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
    <input type="button" name="Submit" id="create-post-btn" value="Submit">
</form>

<!--delete button-->

<!--add edit button, -->

<br>
            
            <div>
                ${props.posts.map(post => `

<h3 id="${post.id}">${post.title}</h3>

<h2>${post.content}</h2>

<!--edit form -->
    <input type="button" data-id="${post.id}" class="edit-post-btn" value="Submit">


`)
        .join('')}   
            </div>
        </main>
    `;

}

PostEvent()
export function PostEvent(){
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

function editPostEvent(){
    $('.edit-post-btn').click(function () {

        let post = {
            title: $("#title").val(),
            content: $("#content").val()
        }
        console.log(post)

        let request = {
            method: 'PUT',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(post)
        }

        fetchData({
                posts: `/api/posts/${this.attr(`data-id`)}`
            },
            request)

    });

}



