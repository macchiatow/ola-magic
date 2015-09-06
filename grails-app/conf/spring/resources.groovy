import com.olamagic.marshaller.AdSourceMarshaller
import com.olamagic.marshaller.CallMarshaller
import com.olamagic.marshaller.CampaignMarshaller
import com.olamagic.marshaller.NumberMarshaller
import com.olamagic.marshaller.SiteMarshaller
import com.olamagic.marshaller.UserMarshaller
import com.olamagic.marshaller.WorkspaceMarshaller
import com.olamagic.util.ObjectMarshallers
import grails.plugin.springsecurity.rest.token.storage.jwt.UserAwareJwtTokenStorageService

// Place your Spring DSL code here
beans = {

    customObjectMarshallers( ObjectMarshallers ) {

        marshallers = [
                new WorkspaceMarshaller(),
                new UserMarshaller(),
                new SiteMarshaller(),
                new NumberMarshaller(),
                new CallMarshaller(),
                new AdSourceMarshaller(),
                new CampaignMarshaller()
        ]

    }

    tokenStorageService(UserAwareJwtTokenStorageService) {
        jwtService = ref('jwtService')
    }
}
