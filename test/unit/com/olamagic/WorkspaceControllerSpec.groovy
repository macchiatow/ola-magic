package com.olamagic
import com.olamagic.auth.SecUser
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import org.junit.Before
import spock.lang.Specification

@TestFor(WorkspaceController)
@Mock([SecUser, Workspace, Profile])
class WorkspaceControllerSpec extends Specification {

    def mockUser = new SecUser(
        email: 'some@email.com',
        password: '***',
        authorities: ['ROLE_USER']
    )

    def mockWorkspace = new Workspace(title: 'One workspace');

    void "Test the 'list' action returns the correct model"() {
        when:"A user instance is created"

            mockUser.save flush: true

        then:"One workspace is already created"
            Workspace.count() == 1

        when:"The index action is executed"
            request.method = 'GET'
            response.format = 'json'
            controller.list(mockUser.id)

        then:"The model is correct"
            response.status == 200
            response.json.workspaces[0].id != null
            response.json.workspaces[0].title != null
    }

    void "Test the 'create' action correctly persists an instance"() {
        when:"Exists user"
            mockUser.save flush: true
        and:"The create action is executed with a valid request"
            request.contentType = JSON_CONTENT_TYPE
            request.method = 'POST'
            request.json = [
                id: 999,  // trying to pass id should not effect
                title: 'Another workspace',
            ]
            controller.create(mockUser.id)

        then:"An instance saved"
            Workspace.count() == 2
            response.status == 200
            response.json.workspace.id != null
            response.json.workspace.title == 'Another workspace'
            response.json.workspace.owner == mockUser.email
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for null"
            request.contentType = JSON_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.status == 404

        when:"A user instance is created"
            response.reset()
            mockUser.save flush: true

        and:"The workspace id is passed to the delete action"
           controller.delete(mockUser.profile.workspaces[0].id)

        then:"The instance is not deleted; at least one workspace should exist for a user"
            Workspace.count() == 1
            response.status == 406

        when:"A user has more than one workspace"
            response.reset()
            mockUser.profile.workspaces << new Workspace(title: 'Second workspace')
            mockUser.save flush: true

        then:"Exist two workspaces"
            Workspace.count() == 2

        when:"The workspace id is passed to the delete action again"
            controller.delete(mockUser.profile.workspaces[0].id)

        then:"The instance is deleted"
            Workspace.count() == 1
            response.status == 200
    }

    static loadExternalBeans = true

    @Before
    void registerJsonMarshallers() {
        applicationContext.getBean('customObjectMarshallers').register()
    }
}
