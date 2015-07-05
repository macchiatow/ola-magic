class UrlMappings {

    static mappings = {
        // Main
        "/"(view: "/index")

        // External
        "/external/calls"(controller: "call") { action = [GET:"list", POST:"notifyCall"] }
        "/external/numbers/$upid/calls"(controller: "call") { action = [GET:"listWithUpid", DELETE:"deleteWithUpid"] }

        // Admin panel
        "/admin/users/new"(controller: "user", view: "new")
        "/admin/users"(controller: "user") { action = [GET:"list", POST:"create"] }
        "/admin/users/$uid"(controller: "user") { action = [GET:"show", PUT:"update", DELETE:"deleteWithUid"] }

        "/admin/numbers/new"(controller: "number", view: "new")
        "/admin/numbers"(controller: "number") { action = [GET:"list", POST:"create"] }
        "/admin/numbers/$upid"(controller: "number") { action = [GET:"show", DELETE:"deleteWithUpid"] }

        // User dashboard
        "/dashboard/$uid/numbers"(action: "listWithUid", controller: "number")
        "/dashboard/$uid/numbers/$upid"(controller: "number") { action = [POST:"buy"] }
        "/dashboard/numbers/$upid"(controller: "number") { action = [DELETE: "release"] }

        // Authentication
        "/login/$action?"(controller: "login")
        "/logout/$action?"(controller: "logout")

        // Errors
        "500"(view: '/error')
    }
}
