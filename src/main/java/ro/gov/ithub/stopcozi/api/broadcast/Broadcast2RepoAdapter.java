package ro.gov.ithub.stopcozi.api.broadcast;

import ro.gov.ithub.stopcozi.model.repo.*;

import java.util.Date;
import java.util.stream.Collectors;

public class Broadcast2RepoAdapter {

    static Agency adaptAgency(ro.gov.ithub.stopcozi.api.broadcast.model.Agency agency){
        Agency repoAgency = new Agency();
        repoAgency.setId(agency.getId());
        repoAgency.setName(agency.getName());
        repoAgency.setDescription(agency.getDescription());
        repoAgency.setAddress(agency.getAddress());
        repoAgency.setCategories(agency.getCategories().stream().map(Broadcast2RepoAdapter::adaptCategory).collect(Collectors.toList()));
        repoAgency.setServices(agency.getServices().stream().map(Broadcast2RepoAdapter::adaptService).collect(Collectors.toList()));
        repoAgency.setDesks(agency.getDesks().stream().map(Broadcast2RepoAdapter::adaptDesk).collect(Collectors.toList()));

        return repoAgency;
    }

    static Category adaptCategory(ro.gov.ithub.stopcozi.api.broadcast.model.Category category){
        Category repoCategory = new Category();
        repoCategory.setId(category.getId());
        repoCategory.setName(category.getName());

        return repoCategory;
    }

    static Service adaptService(ro.gov.ithub.stopcozi.api.broadcast.model.Service service){
        Service repoService = new Service();
        repoService.setId(service.getId());
        repoService.setName(service.getName());
        // TODO: category references need to be set based on their ids
        repoService.setWorkingHours(service.getWorkingHours().stream().map(Broadcast2RepoAdapter::adaptServiceSchedule).collect(Collectors.toList()));
        repoService.setTicketLimit(service.getTicketLimit());
        repoService.setLastIssuedTicket(service.getLastIssuedTicket());

        return repoService;
    }

    static ServiceSchedule adaptServiceSchedule(ro.gov.ithub.stopcozi.api.broadcast.model.ServiceSchedule serviceSchedule){
        ServiceSchedule repoServiceSchedule = new ServiceSchedule();
        repoServiceSchedule.setDayOfWeek(adaptDayOfWeek(serviceSchedule.getDayOfWeek()));
        repoServiceSchedule.setStart(new Date(serviceSchedule.getStart().toEpochSecond()));
        repoServiceSchedule.setEnd(new Date(serviceSchedule.getEnd().toEpochSecond()));
        repoServiceSchedule.setDesks(serviceSchedule.getDesks().stream().map(Broadcast2RepoAdapter::adaptDesk).collect(Collectors.toList()));

        return repoServiceSchedule;
    }

    static Desk adaptDesk(ro.gov.ithub.stopcozi.api.broadcast.model.Desk desk){
        Desk repoDesk = new Desk();
        repoDesk.setId(desk.getId());
        repoDesk.setName(desk.getName());
        repoDesk.setTicketsInProgress(desk.getTicketsInProgress().stream().map(Broadcast2RepoAdapter::adaptTicket).collect(Collectors.toList()));

        return repoDesk;
    }

    static DayOfWeek adaptDayOfWeek(ro.gov.ithub.stopcozi.api.broadcast.model.DayOfWeek dayOfWeek){
        return DayOfWeek.valueOf(dayOfWeek.name());
    }

    static Ticket adaptTicket(ro.gov.ithub.stopcozi.api.broadcast.model.Ticket ticket){
        Ticket repoTicket = new Ticket();
        repoTicket.setTicketNo(ticket.getTicketNo());
        repoTicket.setIssueDateTime(new Date(ticket.getIssueDateTime().toEpochSecond()));
        repoTicket.setStatus(adaptTicketStatus(ticket.getStatus()));
        // TODO: service and desk references need to be set based on their ids

        return repoTicket;
    }

    static TicketStatus adaptTicketStatus(ro.gov.ithub.stopcozi.api.broadcast.model.TicketStatus ticketStatus){
        return TicketStatus.valueOf(ticketStatus.name());
    }
}
