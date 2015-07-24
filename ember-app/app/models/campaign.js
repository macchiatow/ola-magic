import DS from 'ember-data';

export default DS.Model.extend({
  name: DS.attr('string'),
  details: DS.attr('string'),
  site: DS.belongsTo('site'),
  number: DS.hasMany('number')
});
